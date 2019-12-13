package edu.mum.cs544.a4.service;

import java.util.Optional;

import edu.mum.cs544.a4.entity.User;

public interface UserService {

    public User addUser(User user);
    public User updateUser(User user);
    public void deleteUser(long id);
    public User getUserByEmail(String email);
    public User getUserByUsername(String username);
}
