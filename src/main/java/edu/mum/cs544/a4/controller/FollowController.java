package edu.mum.cs544.a4.controller;

import edu.mum.cs544.a4.entity.Follower;
import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.service.FollowerService;
import edu.mum.cs544.a4.service.PostService;
import edu.mum.cs544.a4.service.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FollowController {
    private UserService userService;
    private FollowerService followerService;
    private PostService postService;

    @Autowired
    public FollowController(UserService userService, FollowerService followerService, PostService postService) {
        this.userService = userService;
        this.followerService = followerService;
        this.postService = postService;
    }

    //Show following
    @GetMapping(value = "/following/{id}")
    public String getFollowingList(@PathVariable("id") long id, Model model){
        User user = userService.getUserById(id);
        List<Follower> followingUsers = user.getFollowingUser();
        model.addAttribute("user",user);
        model.addAttribute("followingUsers",followingUsers);
        return "profile/followingModal :: modalContents";
    }

    //show follower
    //Show following
    @GetMapping(value = "/follower/{id}")
    public String getFollowerList(@PathVariable("id") long id, Model model){
        User user = userService.getUserById(id);
        List<Follower> followingUsers = user.getFollowedUsers();
        model.addAttribute("user",user);
        model.addAttribute("followingUsers",followingUsers);
        return "profile/followerModal :: modalContents";
    }

    @RequestMapping(value="profile/followbyajax/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public String ajaxFollow(@PathVariable long userId, Model model) {
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
        User followingUser = userService.getUserById(currentUserId);
        User followedUser = userService.getUserById(userId);

        JSONObject response = new JSONObject();
        if(followerService.addFollowCheck(followingUser,followedUser)) {
            response.put("result",true);
            response.put("followingUser",currentUserId);
            response.put("followedUser",userId);
            response.put("n", followedUser.getFollowedUsers().size());

        }else{
            response.put("result",false);
        }
        return response.toString();
    }

    @RequestMapping(value="profile/unfollowbyajax/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String ajaxUnFollow(@PathVariable long id, Model model) {
        JSONObject response = new JSONObject();
        Long lId = Long.valueOf(id);
        followerService.unfollowB(lId);
        response.put("result",true);
        response.put("n", lId);
        return response.toString();
    }
}
