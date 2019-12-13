package edu.mum.cs544.a4.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.repository.UserRepository;
import edu.mum.cs544.a4.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByPublicName(userName);
    }

    @Override
    public User addFollowing(User followedUser) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);

    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> result = userRepository.findById(userId);

        User user = null;

        if(result.isPresent()){
            user = result.get();
        } else {
            throw new RuntimeException("Did not find the User id = " + userId);
        }
        return user;
    }
}