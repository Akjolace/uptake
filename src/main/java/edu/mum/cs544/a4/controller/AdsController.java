package edu.mum.cs544.a4.controller;

import edu.mum.cs544.a4.entity.Ads;
import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.service.AdsService;
import edu.mum.cs544.a4.service.CountryService;
import edu.mum.cs544.a4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AdsController {
    @Autowired
    private AdsService adsService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/ads")
    public String routeToAds(@ModelAttribute("ads") Ads ads,Model model) {
        model.addAttribute("photoPath","/img/postDefault.png");
        model.addAttribute("countries", countryService.getAllCountry());
        return "advertisement/createAd";
    }

    @PostMapping(value = "/addAds")
    public String addPostData(@Valid @ModelAttribute("ads") Ads ads, BindingResult result, Model model) {
        String email = null;
        User user = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            email = ((UserDetails) principal).getUsername();
            user = userService.getUserByEmail(email);
        } else {
            user = userService.getUserById(2);
        }
        ads.setUser(user);
        if(result.hasErrors()) {
            model.addAttribute("photoPath",ads.getPhoto().getPath());
            model.addAttribute("countries", countryService.getAllCountry());
            return "advertisement/createAd";
        }
        adsService.saveAds(ads);
        return "redirect:/ads";
    }
}
