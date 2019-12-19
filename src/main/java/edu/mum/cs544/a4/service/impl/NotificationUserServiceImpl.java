package edu.mum.cs544.a4.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs544.a4.entity.NotificationUser;
import edu.mum.cs544.a4.repository.NotificationUserRepository;
import edu.mum.cs544.a4.service.NotificationUserService;

@Service
public class NotificationUserServiceImpl implements NotificationUserService {

    @Autowired
    private NotificationUserRepository notificationUserRepository;

    @Override
    public void add(NotificationUser notificationUser) {
        notificationUserRepository.save(notificationUser);
    }

    @Override
    public List<NotificationUser> findByDestinationUserEmail(String email) {
        return notificationUserRepository.findByDestinationUserEmail(email);
    }

    @Override
    public void update(NotificationUser notificationUser) {
        notificationUserRepository.save(notificationUser);
    }

    @Override
    public NotificationUser findById(Long id) {
        return notificationUserRepository.myFindById(id);
    }


    
}