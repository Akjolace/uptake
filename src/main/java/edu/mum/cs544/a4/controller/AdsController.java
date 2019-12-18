package edu.mum.cs544.a4.Controller;

import edu.mum.cs544.a4.entity.Ads;
import edu.mum.cs544.a4.service.AdsService;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @GetMapping(value = "/ads")
    public String routeToAds(@ModelAttribute("ads") Ads ads,Model model) {
        model.addAttribute("photoPath","/img/postDefault.png");
        return "advertisement/createAd";
    }

    @PostMapping(value = "/addAds")
    public String addPostData(@Valid @ModelAttribute("ads") Ads ads, BindingResult result, Model model) {
        String redirect;
        String path = ads.getPhoto().getPath();
        if(result.hasErrors()) { return "advertisement/createAd"; }

        return "redirect:/createAd";
    }
}
