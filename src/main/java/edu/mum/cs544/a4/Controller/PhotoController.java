package edu.mum.cs544.a4.Controller;

import edu.mum.cs544.a4.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @PostMapping("/uploadPhoto")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        System.out.println(file);
        return "redirect:/post/addPost";
    }
}
