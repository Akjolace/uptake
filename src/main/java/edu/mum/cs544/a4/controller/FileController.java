package edu.mum.cs544.a4.controller;

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

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;

@Controller
public class FileController {
    @Autowired
    private PhotoService photoService;

    String photoPath = "src/main/resources/static/files";
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
//            photo.setPath(targetLocation.toString());
            String[] serverPath = targetLocation.toString().split("\\\\");
            photo.setPath("/"+serverPath[serverPath.length-2]+"/"+serverPath[serverPath.length-1]);
            System.out.println(photo.getPath());
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            InputStream in = new FileInputStream(targetLocation.toString());
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
            String[] serverPath = targetLocation.toString().split("\\\\");
            photo.setPath(serverPath[serverPath.length-2]+"/"+serverPath[serverPath.length-1]);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            InputStream in = new FileInputStream(targetLocation.toString());
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
//        Path path = Paths.get(photoPath + "uptakePhoto").toAbsolutePath().normalize();
        File file = new File(photoPath);
        Path path = Paths.get(file.getPath());
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
