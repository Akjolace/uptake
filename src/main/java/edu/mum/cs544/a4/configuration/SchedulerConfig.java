package edu.mum.cs544.a4.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import edu.mum.cs544.a4.entity.NotificationUser;
import edu.mum.cs544.a4.repository.NotificationUserRepository;

@EnableScheduling
@Configuration
public class SchedulerConfig {

    @Autowired
    SimpMessagingTemplate template;

    @Autowired
    NotificationUserRepository repository;
    
    @Scheduled(fixedDelay = 1000000)
    public void sendAdhocMessages() {
        NotificationUser notification = new NotificationUser("onoko", "onokokono@gmail.com", "https://images.unsplash.com/photo-1476657680631-c07285ff2581?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1610&q=80", "has added new image", "1");
       //repository.save(notification);
        template.convertAndSend("/topic/onokokono@gmail.com", notification);
    }
}
