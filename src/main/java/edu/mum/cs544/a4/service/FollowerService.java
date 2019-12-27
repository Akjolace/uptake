package edu.mum.cs544.a4.service;

import edu.mum.cs544.a4.entity.Follower;
import edu.mum.cs544.a4.entity.User;

public interface FollowerService {
//    Follower save(User user, User follow);
    Follower addFollow(User followingUser, User followedUser);
    boolean addFollowCheck(User followingUser, User followedUser);
    int isAfollowingB(long A, long B);
    void unfollowB(Long A);
}
