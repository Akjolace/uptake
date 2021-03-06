package edu.mum.cs544.a4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.cs544.a4.entity.NotificationUser;
import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.entity.onoko.PostForNewsfeed;
import edu.mum.cs544.a4.entity.onoko.UserForSearch;
import edu.mum.cs544.a4.service.NewsfeedService;
import edu.mum.cs544.a4.service.NotificationUserService;
import edu.mum.cs544.a4.service.UserService;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private NewsfeedService newsfeedService;

    @Autowired
    private NotificationUserService notificationUserService;

    @GetMapping(value = { "/", "/home" })
    public String getHome(Model model) {
        // Get logged user
        String email = null;
        User loggedUser = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            email = ((UserDetails) principal).getUsername();
            loggedUser = userService.getUserByEmail(email);
        }
            
        if(loggedUser != null ){
            model.addAttribute("loggedUser",loggedUser);
        }
        return "home/index";
    }

    @CrossOrigin
    @GetMapping("/search/SearchByUsername")
    @ResponseBody
    public List<UserForSearch> findByUsersname(@RequestParam("username") String username) {
        List<UserForSearch> users = userService.findTop10UsersByUsername(username);
        return users;
    }

    @CrossOrigin
    @GetMapping("/search/getNewsfeedByEmail")
    @ResponseBody
    public List<PostForNewsfeed> getNewsfeedByEmail(@RequestParam("email") String email,
            @RequestParam("page") int page) {
        Pageable pageable = PageRequest.of(page, 3);

        List<PostForNewsfeed> posts = newsfeedService.getNewsfeedByEmail(email, pageable);
        return posts;
    }

    @CrossOrigin
    @GetMapping("/search/getLikeCountByPost")
    @ResponseBody
    public Long getLikeCountByPost(@RequestParam("postID") Long postID){
        return newsfeedService.getLikeCountByPost(postID);
    }

    @CrossOrigin
    @GetMapping("/search/getCommentCountByPost")
    @ResponseBody
    public Long getCommentCountByPost(@RequestParam("postID") Long postID){
        return newsfeedService.getCommentCountByPost(postID);
    }

    @CrossOrigin
    @GetMapping("/search/findPostsByDescription")
    @ResponseBody
    public List<PostForNewsfeed> findPostByDescription( @RequestParam("email") String email, @RequestParam("description") String description ){
        return newsfeedService.findPostByDescription(email, description);
    }

    @CrossOrigin
    @GetMapping("/search/findNotificationUserByEmail")
    @ResponseBody
    public List<NotificationUser> findNotificationUserByEmail(@RequestParam("email") String email ){
        return notificationUserService.findByDestinationUserEmail(email);
    }

    @CrossOrigin
    @PutMapping("/update/SeenNotifications")
    @ResponseBody
    public String updateSeenNotifications(@RequestBody List<NotificationUser> notificationUsers){
        for( NotificationUser u : notificationUsers ){
            NotificationUser update = notificationUserService.findById(u.getId());
            update.setHasSeen(true);
            notificationUserService.update(update);
        }
        return "all good";
    }
}