package edu.mum.cs544.a4.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.mum.cs544.a4.entity.onoko.PostForNewsfeed;
import edu.mum.cs544.a4.repository.PostRepository;
import edu.mum.cs544.a4.repository.onoko.NewsfeedRepository;
import edu.mum.cs544.a4.service.NewsfeedService;

@Service
public class NewsfeedServiceImpl implements NewsfeedService {

    @Autowired
    NewsfeedRepository newsfeedRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public List<PostForNewsfeed> getNewsfeedByEmail(String email) {
        return newsfeedRepository.getNewsfeedByEmail(email);
    }

    @Override
    public List<PostForNewsfeed> getNewsfeedByEmail(String email, Pageable page) {
        return newsfeedRepository.getNewsfeedByEmail(email, page);
    }

    @Override
    public Long getLikeCountByPost(Long postID) {
        return newsfeedRepository.getLikeCountByPost(postID);
    }

    @Override
    public Long getCommentCountByPost(Long postID) {
        return newsfeedRepository.getCommentCountByPost(postID);
    }

    @Override
    public List<PostForNewsfeed> findPostByDescription(String email, String description) {
        return newsfeedRepository.findByDescription(email, description);
    }

}