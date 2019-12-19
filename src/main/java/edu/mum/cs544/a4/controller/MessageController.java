package edu.mum.cs544.a4.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import edu.mum.cs544.a4.entity.onoko.MessageTest;

@Controller
public class MessageController {


    @MessageMapping("/user")
    @SendTo("/topic/user")
    public MessageTest getUser(MessageTest messageTest) {
        return messageTest;
    }
}
