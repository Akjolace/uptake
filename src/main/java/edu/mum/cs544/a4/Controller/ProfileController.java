package edu.mum.cs544.a4.controller;

import edu.mum.cs544.a4.entity.Post;
import edu.mum.cs544.a4.entity.Profile;
import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.service.ProfileService;
import edu.mum.cs544.a4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    @Autowired
    private UserService userService;

    @GetMapping(value="/profile/{profileName}")
    public String getProfile(@PathVariable String profileName, Model model){
        System.out.println("Here in get Profile name="+profileName);
        Profile profile = profileService.findByProfileName(profileName);
        User user = userService.findByUserName(profileName);
        model.addAttribute("userprofile", profile);
        System.out.println("User" + user.toString());
        for (Post p:user.getPostList()){
            System.out.println(p);
        }
        model.addAttribute("user", user);
        return "profile/profile";
    }
}
