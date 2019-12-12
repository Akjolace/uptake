package edu.mum.cs544.a4.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthenticationController{

    @GetMapping(value="/login")
    public String getLogin(Model model){
//
        return "auth/login";
    }
}