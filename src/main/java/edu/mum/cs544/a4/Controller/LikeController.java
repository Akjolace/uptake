package edu.mum.cs544.a4.controller;

import edu.mum.cs544.a4.entity.Post;
import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.service.LikeService;
import edu.mum.cs544.a4.service.PostService;
import edu.mum.cs544.a4.service.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LikeController {

    private UserService userService;
    private LikeService likeService;
    private PostService postService;

    @Autowired
    public LikeController(UserService userService, LikeService likeService, PostService postService) {
        this.userService = userService;
        this.likeService = likeService;
        this.postService = postService;
    }

    @RequestMapping(value="profile/likepost/{postId}", method = RequestMethod.GET)
    @ResponseBody
    public String ajaxLike(@PathVariable long postId, Model model) {
        long currentUserId = 3;
        User user = userService.getUserById(currentUserId);
        Post post = postService.findPostById(postId);

        JSONObject response = new JSONObject();
        if(likeService.addLikeCheck(user,post)) {
            response.put("result",true);
            response.put("user",currentUserId);
            response.put("post",postId);
        }else{
            response.put("result",false);
        }
        return response.toString();
    }
}
