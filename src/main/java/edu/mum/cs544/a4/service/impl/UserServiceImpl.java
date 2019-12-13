package edu.mum.cs544.a4.service.impl;

import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.repository.UserRepository;
import edu.mum.cs544.a4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
            // throw Exception
            throw new RuntimeException("Did not find the User id = " + userId);
        }
        return user;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }
}
