package edu.mum.cs544.a4.service;

import edu.mum.cs544.a4.entity.Post;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PostService {
    Long addPost(Post post);
    Optional<Post> findPostById(Long id);
}
