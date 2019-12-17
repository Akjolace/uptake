package edu.mum.cs544.a4.controller;

import edu.mum.cs544.a4.service.CommentService;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(value = "/post/comment")
    @ResponseBody
    public String addComment(Model model) {
        System.out.println("-----------------Add Comment---------------------");
        //add to database
        JSONObject response = new JSONObject();
        response.put("result",true);
        response.put("comment","New Comment");
        response.put("username","User name");
        response.put("created","2019-12-15");
        return response.toString();
    }
}
