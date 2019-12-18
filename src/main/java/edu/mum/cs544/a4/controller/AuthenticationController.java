package edu.mum.cs544.a4.controller;

import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.cs544.a4.entity.Photo;
import edu.mum.cs544.a4.entity.Profile;
import edu.mum.cs544.a4.entity.Role;
import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.service.RoleService;
import edu.mum.cs544.a4.service.UserService;

@Controller
public class AuthenticationController {

    private UserService userService;

    private RoleService roleService;

    private BCryptPasswordEncoder passwordEncoder;

    public AuthenticationController(UserService userService, RoleService roleService,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = bCryptPasswordEncoder;
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping("/authentication/getloggedusername")
    public String getLoggedUsername(Authentication authentication) {
        return authentication.getName();
    }

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
        //Create Profile for user
        Profile profile = new Profile();
        profile.setUser(user);
        //Create Image for user
        Photo photo = new Photo();
        photo.setPath("https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg");
        //add photo to profile
        profile.setPhoto(photo);
        //add Profile to user
        user.setProfile(profile);
        // Encrypt password
        user.setPassword(passwordEncoder.encode(password));
        // set user status
        user.setStatus(true);
        // Save
        userService.addUser(user);

        return "redirect:/login";
    }
}