package edu.mum.cs544.a4.controller;

import edu.mum.cs544.a4.entity.Comment;
import edu.mum.cs544.a4.entity.Post;
import edu.mum.cs544.a4.service.CommentService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String addComment(@ModelAttribute("Comment") Comment comment, Model model) {
        System.out.println("-----------------Add Comment---------------------");
        commentService.add(comment);
        //add to database
        JSONObject response = new JSONObject();
        response.put("result",true);
        response.put("comment",comment.getDescription());
        response.put("username",comment.getUser().getUsername());
        System.out.println(response);
        return response.toString();
    }
}
