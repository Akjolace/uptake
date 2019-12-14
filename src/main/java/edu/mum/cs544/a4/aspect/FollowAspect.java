package edu.mum.cs544.a4.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;

@Aspect
@Configuration
public class FollowAspect {
    /*@Before("execution(* edu.mum.cs544.a4.controller.UptakeProfileController.getProfile(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("------------------------------------Befor getProfile()");
        Model model;
        if(joinPoint.getArgs()[1]!=null){
            ((Model)joinPoint.getArgs()[1]).addAttribute("isFollowing", true);
        }
    }*/
}