package edu.mum.cs544.a4.Controller;

import edu.mum.cs544.a4.entity.Photo;
import edu.mum.cs544.a4.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    String photoPath = "C:\\Users\\mandu\\Pictures\\";

    @PostMapping("/uploadPhoto")
    @ResponseBody
    public Long handleFileUpload(@RequestParam("file") MultipartFile file) {
        System.out.println(file);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Photo photo = new Photo();
        try {
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = getUploadPath().resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            photo.setPath(targetLocation.toString());
            System.out.println(photo.getPath());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return photoService.savePhoto(photo);
    }

    public Path getUploadPath(){
        Path path = Paths.get(photoPath + "uptakePhoto").toAbsolutePath().normalize();
        try {
            if(!Files.exists(path)) {
                Files.createDirectories(path);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return path;
    }
}
