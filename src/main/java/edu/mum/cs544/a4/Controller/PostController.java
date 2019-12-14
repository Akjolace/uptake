package edu.mum.cs544.a4.controller;

import edu.mum.cs544.a4.entity.Post;
import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/addPost")
    public String addPost(Model model) {

        return "post/addPost";
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
        model.addAttribute("post",post);
        model.addAttribute("user",user);
        return "post/postModal :: modalContents";
    }
    @PostMapping(value = "/addPostData")
    public String addPostData(@ModelAttribute("Post") Post post, Model model) {
        System.out.println(post.getTitle());
        postService.addPost(post);
        return "redirect:/addPost";
    }

}
