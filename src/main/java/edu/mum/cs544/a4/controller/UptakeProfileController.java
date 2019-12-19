package edu.mum.cs544.a4.controller;

import edu.mum.cs544.a4.entity.*;
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
    private CountryService countryService;
    private PhotoService photoService;

    @Autowired
    public UptakeProfileController(UserService userService, LikeService likeService, FollowerService followerService,
                                   ProfileService profileService,CountryService countryService,PhotoService photoService) {
        this.userService = userService;
//        this.postService = postService; this.likeService = likeService;
        this.followerService = followerService;
        this.profileService = profileService;
        this.countryService = countryService;
        this.photoService = photoService;
    }

    @GetMapping(value = "/profile/{userName}")
    public String getProfile(@PathVariable String userName, Model model) {
        User user = userService.getUserByUsername(userName);
        int currentUserId = 1;
        boolean isMyAccount = false;
        if(user!=null){
            String email = null;
            User loggedUser = null;
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails){
                email = ((UserDetails) principal).getUsername();
                loggedUser = userService.getUserByEmail(email);
            }

            if(loggedUser != null ){
                currentUserId = loggedUser.getId().intValue();
                model.addAttribute("loggedUser", loggedUser);
                if(loggedUser.getId()==user.getId()){
                    isMyAccount=true;
                }
            }
            boolean isFollowing = followerService.isAfollowingB(currentUserId,user.getId())!=0;
            model.addAttribute("isFollowing", isFollowing);
            model.addAttribute("isMyAccount", isMyAccount);
            model.addAttribute("user", user);

            return "profile/profile";
        }else{
            return "redirect:home/index";
        }
    }
    @GetMapping(value="/account/edit")
    public String getProfile(Model model){
        String email = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            email = ((UserDetails) principal).getUsername();
            User user = userService.getUserByEmail(email);
            model.addAttribute("user",user);
            model.addAttribute("photoPath",user.getProfile().getPhoto().getPath());
        }else {
            // return "redirect:/login";
           User user = userService.getUserById(8L);
           if(user.getProfile()!=null){
               model.addAttribute("photoPath",user.getProfile().getPhoto().getPath());
               model.addAttribute("user",user);
           }else{
               return "/";
           }
        }
        model.addAttribute("countryList",countryService.getAllCountry());
        return "profile/profileform";
    }

    @PostMapping(value="/updateprofile")
    public String updateProfile(@ModelAttribute("user") User user,BindingResult result, RedirectAttributes ra, Model model){
        if(result.hasErrors()) {
            return "account/edit";
        }
        Photo photo = new Photo(user.getProfile().getPhoto().getPath()); //user.getProfile().getPhoto().getPath());
        photoService.savePhoto(photo);
        user.getProfile().setPhoto(photo);
        userService.updateUser(user);
        ra.addFlashAttribute("savedUser",user);
        ra.addFlashAttribute("resultmsg","UPDATED");
        System.out.println("Flash Attribute added and redirect");
        return "redirect:/account/updateresult";
    }
    @GetMapping(value="/updateresult")
    public String updateresult(Model model){
        System.out.println("In result");
        return "profile/profiledetail";
    }
}
