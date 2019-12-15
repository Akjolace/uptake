package edu.mum.cs544.a4.service.impl;

import edu.mum.cs544.a4.entity.Follower;
import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.repository.FollowRepository;
import edu.mum.cs544.a4.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowerServiceImpl implements FollowerService {

    private FollowRepository followRepository;

    @Autowired
    public FollowerServiceImpl(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    @Override
    public Follower addFollow(User followingUser, User followedUser) {
        return followRepository.save(new Follower(followingUser,followedUser));
    }

    @Override
    public boolean addFollowCheck(User followingUser, User followedUser) {
        System.out.println("AddFollowCheck" + followingUser.getId() + ", " + followedUser.getId());
        if(followedUser.getId()!=followingUser.getId()){
            if(isAfollowingB(followingUser.getId(),followedUser.getId())==0) {
                followRepository.save(new Follower(followingUser,followedUser));
                return true;
            }
        }
        return false;
    }

    @Override
    public int isAfollowingB(long A, long B) {
        return followRepository.isAfollowingB(A,B);
    }

//    @Override
//    public Follower save(User user, User follow) {
//        return followRepository.save(new Follower(user, follow));
//    }
}
