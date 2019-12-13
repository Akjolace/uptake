package edu.mum.cs544.a4.controller;

import edu.mum.cs544.a4.entity.Post;
import edu.mum.cs544.a4.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/addPost")
    public String addPost(Model model) {

        return "post/addPost";
    }

    @GetMapping(value = "/post/{id}")
    public String getProfile(@PathVariable Long id, Model model) {
        Optional<Post> post = postService.findPostById(id);
        model.addAttribute("post", post);
        System.out.println("===========================================");
        System.out.println(post);
        return "post/postCard";
    }
}
