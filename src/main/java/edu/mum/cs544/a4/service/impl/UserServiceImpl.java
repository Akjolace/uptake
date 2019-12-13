package edu.mum.cs544.a4.service.impl;

import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.repository.UserRepository;
import edu.mum.cs544.a4.service.UserService;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;


    @Override
    public User findByUserName(String userName) {
        return userRepository.findByPublicName(userName);
    }

    @Override
    public User addFollowing(User followedUser) {
        return null;
    }

}
