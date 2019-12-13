package edu.mum.cs544.a4.Controller;

import edu.mum.cs544.a4.entity.Post;
import edu.mum.cs544.a4.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping(value="/addPost")
    public String addPost(Model model) {

        return "post/addPost";
    }

    @PostMapping(value="/addPostData")
    public String addPostData(@ModelAttribute("Post") Post post, Model model) {
        System.out.println(post.getTitle());
        postService.addPost(post);
        return "redirect:/addPost";
    }
}
