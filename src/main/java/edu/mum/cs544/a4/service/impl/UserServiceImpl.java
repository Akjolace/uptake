package edu.mum.cs544.a4.service.impl;

import java.util.List;

import edu.mum.cs544.a4.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.entity.onoko.UserForSearch;
import edu.mum.cs544.a4.repository.UserRepository;
import edu.mum.cs544.a4.repository.onoko.UserForSearchRepository;
import edu.mum.cs544.a4.service.UserService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private UserForSearchRepository userForSearchRepository;
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserForSearchRepository userForSearchRepository) {
        this.userRepository = userRepository;
        this.userForSearchRepository = userForSearchRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public User addFollowing(User followedUser) {
        return null;
    }

    @Override
    public boolean deactivateUser(long userId) {
        return userRepository.deactivateUser(userId);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
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
    public User getUserById(long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<UserForSearch> findTop10UsersByUsername(String username){
        return userForSearchRepository.findTop10UsersByUsername(username);
    }

    public Page<User> getAllUsers(Pageable pageable){
        return userRepository.findAll(pageable);
    }
}