package edu.mum.cs544.a4.service;

import edu.mum.cs544.a4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserService{
    User findByUserName(String userName);
    User addFollowing(User followedUser);
}
