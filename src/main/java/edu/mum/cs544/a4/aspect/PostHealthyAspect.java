package edu.mum.cs544.a4.aspect;


import edu.mum.cs544.a4.entity.Post;
import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.service.PostService;
import edu.mum.cs544.a4.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class PostHealthyAspect {
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    //@Around(value = "execution(* edu.mum.cs544.a4.service.PostService.addPost(..))")
    public Object filter(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        boolean isUnhealthy = false;

//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println("PRINCIPAL " + principal);
//        String email = SecurityContextHolder.getContext().getAuthentication().getName();
//        System.out.println("EMAIL AROUND " + email);
//        User user = userService.getUserByEmail(email);

        Object[] args = proceedingJoinPoint.getArgs();
        if (proceedingJoinPoint.getTarget() instanceof PostService) {
            Post post = (Post) args[0];
//            System.out.println("FILTERING POST : " + post);
//            System.out.println(hasBadWords(post.getDescription()));
            if(hasBadWords(post.getDescription())) {
                post.setUnhealthy(true);
                String email = null;
                User user = null;
                Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                if (principal instanceof UserDetails){
                    email = ((UserDetails) principal).getUsername();
                    user = userService.getUserByEmail(email);
                    long userId = user.getId();
                    int unhealthyCount = postService.countUnhealthyPost(userId);
                    if(unhealthyCount > 2) {
                        user.setStatus(false);
                        post.setUser(user);
                        userService.deactivateUser(userId);
                    }
                }
            }
        }

//        if ( user == null ) {
//            throw new Exception("USER NOT FOUND");
//        }
        Object ret = proceedingJoinPoint.proceed(args);
        return ret;
    }

    public boolean hasBadWords(String paragraph) {
        List<String> list= Arrays.asList("stupid","shit","bad");
        for(String word: list)
            if(paragraph.contains(word))
                return true;
        return false;
    }
}

