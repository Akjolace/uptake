package edu.mum.cs544.a4.controller;

import edu.mum.cs544.a4.entity.Gender;
import edu.mum.cs544.a4.entity.Profile;
import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UptakeProfileController {

    private UserService userService;
//    private PostService postService;
//    private LikeService likeService;
    private FollowerService followerService;
    private ProfileService profileService;
    private Gender gender;

    @Autowired
    public UptakeProfileController(UserService userService, LikeService likeService, FollowerService followerService, ProfileService profileService) {
        this.userService = userService;
//        this.postService = postService; this.likeService = likeService;
        this.followerService = followerService;
        this.profileService = profileService;
    }

    @GetMapping(value = "/profile/{userName}")
    public String getProfile(@PathVariable String userName, Model model) {
        User user = userService.getUserByUsername(userName);
        if(user!=null){
            long currentUserId = 1;

            String email = null;
            User loggedUser = null;
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails){
                email = ((UserDetails) principal).getUsername();
                loggedUser = userService.getUserByEmail(email);
            }

            if(loggedUser != null ){
                currentUserId = loggedUser.getId();
            }

            boolean isFollowing = followerService.isAfollowingB(currentUserId,user.getId())==0?false:true;
            System.out.println("---------------------- is Following 3->"+ user.getId()+ isFollowing);
            model.addAttribute("isFollowing", isFollowing);
            model.addAttribute("user", user);

            return "profile/profile";
        }else{
            return "redirect:home/index";
        }
    }

    @GetMapping(value="/profile/manage")
    public String getProfile(@ModelAttribute("profile") Profile profile, Model model){
        String email = null;
        User loggedUser = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            email = ((UserDetails) principal).getUsername();
            loggedUser = userService.getUserByEmail(email);
        }

        if(loggedUser != null ){
            model.addAttribute("profile",loggedUser.getProfile());
        }
        System.out.println("profile" + profile);
        return "profile/profileform";
    }

    @PostMapping(value="/profile/update")
    public String updateProfile(@Valid @ModelAttribute("profile") Profile profile, BindingResult result , RedirectAttributes ra){
        if(result.hasErrors()) {
            System.out.println("Got Error");
            result.getAllErrors().stream().forEach(e-> System.out.println(e));
            System.out.println(result.hasErrors());
            return "profile/profileform";
        }
        profileService.updateProfile(profile);
        ra.addFlashAttribute("savedProfile",profile);
        return "redirect:/profile/profiledetail";
    }

    @GetMapping(value="/profile/profiledetail")
    public String getProfile(){
        return "profile/profiledetail";
    }
}
