package edu.mum.cs544.a4.service;

import java.util.List;

import edu.mum.cs544.a4.entity.User;

public interface UserService {

    public User addUser(User user);

    public User updateUser(User user);

    public void deleteUser(long id);

    public User getUserByEmail(String email);

    public User getUserByUsername(String username);

    public User getUserById(long userId);

    public List<User> getAllUser();

    User findByUserName(String userName);

    User addFollowing(User followedUser);
}
