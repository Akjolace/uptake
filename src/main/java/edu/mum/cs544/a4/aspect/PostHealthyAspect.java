package edu.mum.cs544.a4.aspect;


import edu.mum.cs544.a4.entity.Post;
import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.service.PostService;
import edu.mum.cs544.a4.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PostHealthyAspect {

    private UserService userService;
    private PostService postService;

    @Around(value = "execution(* edu.mum.cs544.a4.service.PostService.addPost(..))")
    public Object filter(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        boolean isUnhealthy = false;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("PRINCIPAL " + principal);
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("EMAIL AROUND " + email);
        User user = userService.getUserByEmail(email);

        Object[] args = proceedingJoinPoint.getArgs();
        if (proceedingJoinPoint.getTarget() instanceof PostService) {
            Post post = (Post) args[0];
            System.out.println("FILTERING POST : " + post);
        }

        if ( user == null ) {
            throw new Exception("USER NOT FOUND");
        }
        Object ret = proceedingJoinPoint.proceed(args);

        return ret;
    }
}
