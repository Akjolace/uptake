package edu.mum.cs544.a4.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.cs544.a4.entity.Role;
import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.service.RoleService;
import edu.mum.cs544.a4.service.UserService;

@Controller
public class AuthenticationController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @GetMapping(value = "/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error, Model model) {
        String errorMessages = null;

        if (error != null)
            errorMessages += " password";

        model.addAttribute("errorMessages", errorMessages);

        return "auth/login";
    }

    @GetMapping(value = "/register")
    public String getRegister(@ModelAttribute("User") User user, Model model) {
        return "auth/register";
    }

    @PostMapping(value = "/register")
    public String postRegister(@Valid @ModelAttribute("User") User user, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "auth/register";
        }
        // Check email
        User newUser = userService.getUserByEmail(user.getEmail());
        if (newUser != null)
            result.rejectValue("email", "errorMsg.emailExists");

        // Check username
        newUser = userService.getUserByUsername(user.getUsername());
        if (newUser != null)
            result.rejectValue("username", "errorMsg.usernameExists");

        // Check password
        String password = user.getPassword();
        String passwordConfirm = user.getPasswordConfirm();
        if (!password.equals(passwordConfirm))
            result.rejectValue("passwordConfirm", "errorMsg.passwordConfirm");

        if (result.hasErrors()) {
            return "auth/register";
        }

        // Get and set user role
        Role role = roleService.findRoleByName("ROLE_USER");
        user.getRole().add(role);
        // Encrypt password
        user.setPassword(passwordEncoder.encode(password));
        // set user status
        user.setStatus(true);
        // Save
        userService.addUser(user);

        return "redirect:/login";
    }
}