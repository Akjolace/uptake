package edu.mum.cs544.a4.service;

import edu.mum.cs544.a4.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface PostService {

    Long addPost(Post post);

    Long editPost(Post post);

    Post findPostById(long id);

    public List<Post> getAllPost();
}
