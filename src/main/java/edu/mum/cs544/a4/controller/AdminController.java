package edu.mum.cs544.a4.controller;

import edu.mum.cs544.a4.entity.Ads;
import edu.mum.cs544.a4.entity.Post;
import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.service.AdsService;
import edu.mum.cs544.a4.service.PostService;
import edu.mum.cs544.a4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class AdminController {

    private UserService userService;
    private PostService postService;
    private AdsService adsService;

    @Autowired
    public AdminController(UserService userService, PostService postService, AdsService adsService) {
        this.userService = userService;
        this.postService = postService;
        this.adsService = adsService;

    }

    @GetMapping(value = "/admin")
    public String getAdmin() {
        return "admin/adminBase";
    }

    @GetMapping(value = "/admin/users")
    public String listUser(@ModelAttribute("users") User user, Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "admin/adminUsers";
    }

//    @PostMapping(value = "/admin/users")
//    public String addUser(@ModelAttribute("users") User user, Model model, RedirectAttributes redirectAttributes) {
//        redirectAttributes.addFlashAttribute("users", userService.addUser(user));
//        return "redirect:/admin/users";
//    }

    @GetMapping(value = "/admin/posts")
    public String listPost(@ModelAttribute("posts") Post post, Model model) {
        model.addAttribute("posts", postService.getAllPost());
        System.out.println("POST PRINTING ******" + postService.getAllPost());
        return "admin/adminPosts";
    }

    @GetMapping("/admin/users/{userId}")
    public User getUser(@PathVariable Long userId) {
        return userService.getUserById(userId);
        //If employee is not found -> throw Exception
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        userService.addUser(user);
        return user;
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
