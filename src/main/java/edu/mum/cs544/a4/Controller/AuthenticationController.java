package edu.mum.cs544.a4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController{

    @GetMapping(value="/login")
    public String getLogin(@RequestParam( value = "error", required= false ) String error, Model model){
        String errorMessages = null;
    
        if(error != null)
            errorMessages += " password";

        model.addAttribute("errorMessages",errorMessages);

        return "auth/login";
    }
}