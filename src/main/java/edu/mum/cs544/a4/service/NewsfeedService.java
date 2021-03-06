package edu.mum.cs544.a4.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import edu.mum.cs544.a4.entity.onoko.PostForNewsfeed;

public interface NewsfeedService {

    public List<PostForNewsfeed> getNewsfeedByEmail(String email);

    public List<PostForNewsfeed> getNewsfeedByEmail(String email, Pageable page);

    public List<PostForNewsfeed> findPostByDescription(String email, String description);

    public Long getLikeCountByPost(Long postID);

    public Long getCommentCountByPost(Long postID);

}