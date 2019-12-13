package edu.mum.cs544.a4.service;

import edu.mum.cs544.a4.entity.Post;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface PostService {

    Long addPost(Post post);

    Post findPostById(long id);
}
