package edu.mum.cs544.a4.controller;

import edu.mum.cs544.a4.entity.Follower;
import edu.mum.cs544.a4.entity.Post;
import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.service.FollowerService;
import edu.mum.cs544.a4.service.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UptakeProfileController {

    private UserService userService;

    private FollowerService followerService;

    @Autowired
    public UptakeProfileController(UserService userService, FollowerService followerService) {
        this.userService = userService;
        this.followerService = followerService;
    }

    @GetMapping(value = "/profile/{userName}")
    public String getProfile(@PathVariable String userName, Model model) {
        User user = userService.getUserByUsername(userName);
        if(user!=null){
            long currentUserId = 3;

            boolean isFollowing = followerService.isAfollowingB(currentUserId,user.getId())==0?false:true;
            System.out.println("---------------------- is Following 3->"+ user.getId()+ isFollowing);
            model.addAttribute("isFollowing", isFollowing);
            model.addAttribute("user", user);

            return "profile/profile";
        }else{
            return "redirect:home/index";
        }
    }
    /*@GetMapping(value = "profile/follow/{userId}")
    public String follow(@PathVariable long userId, Model model) {
        User followedUser = userService.getUserById(userId);
        long currentUserId = 3;
        User followingUser = userService.getUserById(currentUserId);
        Follower follower = followerService.addFollow(followingUser,followedUser);

        boolean isFollowing = followerService.isAfollowingB(currentUserId,followedUser.getId())==0?false:true;
        model.addAttribute("isFollowing", isFollowing);
        model.addAttribute("user", followingUser);
        return "redirect:/profile/" + followingUser.getUsername();
    }*/
    //AJAX FOLLOW
    @RequestMapping(value="profile/followbyajax/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public String followAjax(@PathVariable long userId, Model model) {
        long currentUserId = 3;
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

    @GetMapping(value = "/following/{id}")
    public String getFollowingList(@PathVariable("id") long id, Model model){
        System.out.println("Post detail");
        User user = userService.getUserById(id);
        List<Follower> followingUsers = user.getFollowingUser();
        model.addAttribute("user",user);
        model.addAttribute("followingUsers",followingUsers);
        return "profile/followingModal :: modalContents";
    }
}
