package edu.mum.cs544.a4.controller;

import edu.mum.cs544.a4.entity.Ads;
import edu.mum.cs544.a4.entity.Post;
import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.service.AdsService;
import edu.mum.cs544.a4.service.CommentService;
import edu.mum.cs544.a4.service.PostService;
import edu.mum.cs544.a4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class AdminController {

    private final static Pageable firstPageWithTenElements = (Pageable) PageRequest.of(0, 10);
    private final static Pageable firstPageWithFiveElements = (Pageable) PageRequest.of(0, 5);


    private UserService userService;
    private PostService postService;
    private AdsService adsService;
    private CommentService commentService;

    @Autowired
    public AdminController(UserService userService, PostService postService, AdsService adsService, CommentService commentService) {
        this.userService = userService;
        this.postService = postService;
        this.adsService = adsService;
        this.commentService = commentService;

    }
    /*-------------------------------BASE--------------------------------- */

    @GetMapping(value = "/admin")
    public String getAdmin(Model model) {
        model.addAttribute("userSize", userService.getAllUser().size());
        model.addAttribute("postSize", postService.getAllPost().size());
        model.addAttribute("commentSize", commentService.findAllComments().size());
        model.addAttribute("adsSize", adsService.getAllAds().size());
        return "admin/adminBase";
    }

    /*-------------------------------USER--------------------------------- */

    @GetMapping(value = "/admin/users")
    public String listUser(@ModelAttribute("users") User user, Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "admin/adminUsers";
    }

    @PostMapping("/admin/users")
    @ResponseBody
    public String updateUserStatus(@RequestParam("userId") String userId) {
        User user = userService.getUserById(Long.parseLong(userId));
        if (user.isStatus())
            user.setStatus(false);
        else
            user.setStatus(true);
        userService.addUser(user);
        return (user.isStatus()) ? "Active" : "Inactive";
    }

    @GetMapping(path = "/admin/users/{id}")
    public String viewUser(@PageableDefault(size = 5) Pageable pageable,
                           @PathVariable("id") Long id,
                           Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        Page<Post> postPages = postService.getAllByUser(user, pageable);
        model.addAttribute("postPages", postPages);
        model.addAttribute("comments", commentService.getAllByUser(user));
        return "admin/viewUser";
    }

    /*-------------------------------POST--------------------------------- */

    @GetMapping(value = "/admin/posts")
    public String listPost(@ModelAttribute("posts") Post post,
                           @PageableDefault(size = 10) Pageable pageable,
                           Model model) {
//        model.addAttribute("posts", postService.getAllPost());
        model.addAttribute("postPages", postService.getAllPosts(pageable));
        return "admin/adminPosts";
    }

    /*-------------------------------ADVERTISEMENT--------------------------------- */
    @GetMapping(value = "/admin/ads")
    public String listAds(@ModelAttribute("ads") Ads ads, Model model) {
        model.addAttribute("ads", adsService.getAllAds());
        return "admin/adminAds";
    }

//    @PostMapping("/admin/ads")
//    public String addAds(@RequestParam("file") MultipartFile file,
//                         @ModelAttribute("ads") Ads ads,
//                         BindingResult result, RedirectAttributes ra,
//                         Model model){
//
//        if(file.isEmpty()) {
//            ra.addFlashAttribute("message", "Please select a file to upload");
//            return "redirect:/ads/addProduct";
//        }
//
//        adsService.saveAds(ads);
//
//        return "redirect:/admin/adminAds";
//    }
}
