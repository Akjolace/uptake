package edu.mum.cs544.a4.controller;

import edu.mum.cs544.a4.entity.Follower;
import edu.mum.cs544.a4.entity.Post;
import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.service.FollowerService;
import edu.mum.cs544.a4.service.LikeService;
import edu.mum.cs544.a4.service.PostService;
import edu.mum.cs544.a4.service.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UptakeProfileController {

    private UserService userService;
    private PostService postService;
    private LikeService likeService;
    private FollowerService followerService;

    @Autowired
    public UptakeProfileController(UserService userService, PostService postService, LikeService likeService, FollowerService followerService) {
        this.userService = userService;
        this.postService = postService;
        this.likeService = likeService;
        this.followerService = followerService;
    }

    @GetMapping(value = "/profile/{userName}")
    public String getProfile(@PathVariable String userName, Model model) {
        User user = userService.getUserByUsername(userName);
        if(user!=null){
            long currentUserId = 3;

            boolean isFollowing = followerService.isAfollowingB(currentUserId,user.getId())==0?false:true;
            System.out.println("---------------------- is Following 3->"+ user.getId()+ isFollowing);
            model.addAttribute("isFollowing", isFollowing);
            model.addAttribute("user", user);

            return "profile/profile";
        }else{
            return "redirect:home/index";
        }
    }
}
