package edu.mum.cs544.a4.controller;

import edu.mum.cs544.a4.entity.Photo;
import edu.mum.cs544.a4.entity.Post;
import edu.mum.cs544.a4.service.PhotoService;
import edu.mum.cs544.a4.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private PhotoService photoService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/addPost")
    public String addPost(Model model) {

        return "post/addPost";
    }

    @GetMapping(value = "/post/{id}")
    public String getProfile(@PathVariable Long id, Model model) {
        Post post = postService.findPostById(id);
        model.addAttribute("post", post);
        System.out.println("===========================================");
        System.out.println(post);
        return "post/postCard";
    }

    @PostMapping(value = "/addPostData")
    public String addPostData(@RequestParam("title") String title, @RequestParam("description") String description,@RequestParam("photoPath") String photoPath) {
        Post post = new Post();
        Photo photo = new Photo();
        photo.setPath(photoPath);
        post.setTitle(title);
        post.setDescription(description);
        photoService.savePhoto(photo);
        post.setPhoto(photo);
        postService.addPost(post);
        return "redirect:/addPost";
    }
}
