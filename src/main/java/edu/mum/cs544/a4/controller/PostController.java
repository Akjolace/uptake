package edu.mum.cs544.a4.controller;

import edu.mum.cs544.a4.entity.Photo;
import edu.mum.cs544.a4.entity.Post;
import edu.mum.cs544.a4.service.LikeService;
import edu.mum.cs544.a4.service.PhotoService;
import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.service.PostService;
import edu.mum.cs544.a4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private PhotoService photoService;

    @Autowired
    private LikeService likeService;

    @Autowired
    private UserService userService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/postPhoto")
    public String addPhotoPost(@ModelAttribute("Post") Post post,Model model) {
        model.addAttribute("photoPath","/img/postDefault.png");
        String email = null;
        User user = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            email = ((UserDetails) principal).getUsername();
            user = userService.getUserByEmail(email);
            model.addAttribute("user",user);
        }
        return "post/postPhoto";
    }

    @GetMapping(value = "/postVideo")
    public String addVideoPost(@ModelAttribute("Post") Post post,Model model) {
        return "post/postVideo";
    }

    @PutMapping(value = "/postEdit")
    public String editPostDirect(@ModelAttribute("User") Post post, Model model) {
        model.addAttribute("post", post);
        return "post/editPost";
    }

   /* @GetMapping(value = "/post/{id}")
    public String getProfile(@PathVariable Long id, Model model) {
        Post post = postService.findPostById(id);
        model.addAttribute("post", post);
        System.out.println("===========================================");
        System.out.println(post);
        return "post/postCard";
    }
*/
    @GetMapping("/post/{id}")
    public String postDetail(@PathVariable("id") long id, Model model){
        System.out.println("Post detail");
        Post post = postService.findPostById(id);
        User user = post.getUser();

        System.out.println(user.toString());
        int currentUserId = 3;
        model.addAttribute("hasLiked",likeService.isALikedPostB(currentUserId,id));
        model.addAttribute("post",post);
        model.addAttribute("user",user);
        System.out.println(post.getPhoto().getPath().split("\\.")[1]);
        if(post.getPhoto().getPath().split("\\.")[1].equals("mp4"))
            model.addAttribute("isVideo",true);
        else
            model.addAttribute("isVideo",false);
        return "post/postModal :: modalContents";
    }

//    @PostMapping(value = "/addPostPhoto")
//    public String addPostData(@RequestParam("title") String title, @RequestParam("description") String description,@RequestParam("photoPath") String photoPath) {
//        Post post = new Post();
//        Photo photo = new Photo();
//        photo.setPath(photoPath);
//        post.setTitle(title);
//        post.setDescription(description);
//        photoService.savePhoto(photo);
//        post.setPhoto(photo);
//        postService.addPost(post);
//        return "redirect:/postPhoto";
//    }

    @PostMapping(value = "/addPostPhoto")
    public String addPostData(@Valid @ModelAttribute("Post") Post post, BindingResult result, Model model) {
        String redirect;
        String path = post.getPhoto().getPath();
        System.out.println(post.toString());
        if(result.hasErrors()) {
            String route;
            System.out.println(path.split("\\.")[1]);
            model.addAttribute("photoPath",post.getPhoto().getPath());
            route = (path.split("\\.")[1].equals("mp4")) ? "post/postVideo" : "post/postPhoto";

            return route;
        }
        redirect = (path.split("\\.")[1].equals("mp4")) ? "redirect:/postVideo" : "redirect:/postPhoto";
        postService.addPost(post);
        return redirect;
    }

    @PostMapping(value = "/editPostData")
    public String editPostData(@ModelAttribute("User") Post post) {
        postService.editPost(post);
        return "redirect:/postPhoto";
    }

    @PostMapping(value = "/updatePostStatus")
    @ResponseBody
    public String updatePostStatus(@RequestParam("postId") String postId) {
        Post post = postService.findPostById(Long.parseLong(postId));
        if(post.getStatus() == 1)
            post.setStatus(0);
        else
            post.setStatus(1);
        postService.addPost(post);
        return  post.getStatus()+"";
    }


}
