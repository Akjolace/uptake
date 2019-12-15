package edu.mum.cs544.a4.service.impl;

import edu.mum.cs544.a4.entity.Like;
import edu.mum.cs544.a4.entity.Post;
import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.repository.LikeRepository;
import edu.mum.cs544.a4.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

    private LikeRepository likeRepository;

    @Autowired
    public LikeServiceImpl(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public Like addLike(User user, Post post) {
        return likeRepository.save(new Like(user, post));
    }

    @Override
    public boolean addLikeCheck(User user, Post post) {
        System.out.println("AddLikeCheck"+user.getId() + ", " + post.getId());
        if(likeRepository.isALikedB(user.getId(),post.getId())==0){
            likeRepository.save(new Like(user,post));
            return true;
        }
        return false;
    }

    @Override
    public int isALikedPostB(long A, long B) {
        return likeRepository.isALikedB(A,B);
    }
}
