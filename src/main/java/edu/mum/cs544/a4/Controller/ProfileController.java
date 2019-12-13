package edu.mum.cs544.a4.controller;

import edu.mum.cs544.a4.entity.Profile;
import edu.mum.cs544.a4.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping(value="/profile/{profileName}")
    public String getProfile(@PathVariable String profileName, Model model){
        System.out.println("Here in get Profile name="+profileName);
        Profile profileObj = profileService.findByProfileName(profileName);

        model.addAttribute("profile", profileService.findByProfileName(profileName));
        return "profile/profile";
    }
}
