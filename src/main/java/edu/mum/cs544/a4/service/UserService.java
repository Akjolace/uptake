package edu.mum.cs544.a4.service;

import edu.mum.cs544.a4.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();
    public User getUserById(Long userId);
    public void addUser(User user);
}
