package edu.mum.cs544.a4.Controller;

import edu.mum.cs544.a4.entity.Photo;
import edu.mum.cs544.a4.entity.Post;
import edu.mum.cs544.a4.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;

@Controller
public class FileController {
    @Autowired
    private PhotoService photoService;

    String photoPath = "C:\\Users\\mandu\\Pictures\\";

    @PostMapping("/uploadPhoto")
    @ResponseBody
    public HashMap<String, Object> handleFileUpload(@RequestParam("file") MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        HashMap<String, Object> map = new HashMap<>();
        Photo photo = new Photo();
        try {
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = getUploadPath().resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            photo.setPath(targetLocation.toString());
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            InputStream in = new FileInputStream(photo.getPath());
            byte[] buffer = new byte[1024];
            int len;

            while((len = in.read(buffer)) != -1) {
                os.write(buffer,0 , len);
            }
            map.put("byteArray", os.toByteArray());
            map.put("path", photo.getPath());
            System.out.println(photo.getPath());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return map;
    }

    @PostMapping("/uploadVideo")
    @ResponseBody
    public HashMap<String, Object> handleVideoUpload(@RequestParam("file") MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        HashMap<String, Object> map = new HashMap<>();
        System.out.println(fileName);
        Photo photo = new Photo();
        try {
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = getUploadPath().resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            photo.setPath(targetLocation.toString());
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            InputStream in = new FileInputStream(photo.getPath());
            byte[] buffer = new byte[1024];
            int len;

            while((len = in.read(buffer)) != -1) {
                os.write(buffer,0 , len);
            }
            map.put("byteArray", os.toByteArray());
            map.put("path", photo.getPath());
            System.out.println(photo.getPath());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return map;
    }

//    @RequestMapping(value = "/image/{imageId}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
//    @ResponseBody
//    public byte[] getPhoto(@PathVariable Long imageId) {
//        try {
//            Photo photo = photoService.getPhoto(imageId);
//            try{
//                ByteArrayOutputStream os = new ByteArrayOutputStream();
//                InputStream in = new FileInputStream(photo.getPath());
//                byte[] buffer = new byte[1024];
//                int len;
//
//                while((len = in.read(buffer)) != -1) {
//                    os.write(buffer,0 , len);
//                }
//                return os.toByteArray();
//            } catch(IOException ex) {
//                return null;
//            }
//
//        } catch (Exception ex) {
//            return null;
//        }
//    }

    public Path getUploadPath() {
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
