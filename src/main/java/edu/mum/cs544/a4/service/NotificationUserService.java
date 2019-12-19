package edu.mum.cs544.a4.service;

import java.util.List;

import edu.mum.cs544.a4.entity.NotificationUser;

public interface NotificationUserService {

    public void add(NotificationUser notificationUser);
    public List<NotificationUser> findByDestinationUserEmail(String email);

    public void update(NotificationUser notificationUser);
    public NotificationUser findById(Long id);

}