package edu.mum.cs544.a4.service;

import edu.mum.cs544.a4.entity.Post;

import java.util.List;

public interface PostService {

    Long addPost(Post post);

    Long editPost(Post post);

    Post findPostById(long id);

    public List<Post> getAllPost();

}
