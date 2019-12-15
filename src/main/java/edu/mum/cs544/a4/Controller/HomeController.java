package edu.mum.cs544.a4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.cs544.a4.entity.onoko.UserForSearch;
import edu.mum.cs544.a4.service.UserService;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping(value = { "/", "/home" })
    public String getHome() {
        //Get logged user
        String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }

        
        

        return "home/index";
    }

    @CrossOrigin
    @GetMapping("/search/SearchByUsername")
    @ResponseBody
    public List<UserForSearch> findByUsersname(@RequestParam("username") String username) {
        List<UserForSearch> users = userService.findTop10UsersByUsername(username);
        for (UserForSearch user : users) {
            System.out.println(user.getUsername());
        }
        return users;
    }

}