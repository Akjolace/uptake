package edu.mum.cs544.a4.service;

import edu.mum.cs544.a4.entity.Like;
import edu.mum.cs544.a4.entity.Post;
import edu.mum.cs544.a4.entity.User;

public interface LikeService {

    Like addLike(User user, Post post);
    boolean addLikeCheck(User user, Post post);
    int isALikedPostB(long A, long B);

}
