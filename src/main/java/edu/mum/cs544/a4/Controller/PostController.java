package edu.mum.cs544.a4.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostController {
    @GetMapping(value="/addPost")
    public String addPost(Model model) {

        return "post/postAdd";
    }
}
