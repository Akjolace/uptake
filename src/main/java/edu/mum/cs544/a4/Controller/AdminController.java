package edu.mum.cs544.a4.controller;

import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.repository.UserRepository;
import edu.mum.cs544.a4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/admin")
public class AdminController {

    private UserService userService;

    @Autowired
    public AdminController(UserService userService){
        this.userService = userService;
    }

    @GetMapping({"/admin","/home"})
    public String getAdmin(){
        return "admin/base";
    }

    @GetMapping("/users")
    public List<User> getUserList(){
        return userService.getAllUser();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable Long userId){
        return userService.getUserById(userId);
        //If employee is not found -> throw Exception
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        userService.addUser(user);
        return user;
    }


}
