package edu.mum.cs544.a4.controller;

import edu.mum.cs544.a4.entity.Follower;
import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.service.FollowerService;
import edu.mum.cs544.a4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UptakeProfileController {

    private UserService userService;

    private FollowerService followerService;

    @Autowired
    public UptakeProfileController(UserService userService, FollowerService followerService) {
        this.userService = userService;
        this.followerService = followerService;
    }

    @GetMapping(value = "/profile/{userName}")
    public String getProfile(@PathVariable String userName, Model model) {
        User user = userService.getUserByUsername(userName);
        long currentUserId = 3;
       // model.addAttribute("isFollowing", followerService.isAfollowingB(currentUserId,user.getId()));
        model.addAttribute("isFollowing", false);
        model.addAttribute("user", user);
        return "profile/profile";
    }

    @GetMapping(value = "/profile/follow/{userId}")
    public String follow(@PathVariable long userId, Model model) {
        System.out.println("CALLED BY AJAX");
        User followedUser = userService.getUserById(userId);
        long currentUserId = 3;
        User followingUser = userService.getUserById(currentUserId);
        Follower follower = followerService.addFollow(followingUser,followedUser);
        model.addAttribute("isFollowing", false);
        model.addAttribute("user", followingUser);
        return "redirect:/profile/" + followingUser.getUsername();

    }
}
