package edu.mum.cs544.a4.service;

import edu.mum.cs544.a4.entity.Post;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    public Long addPost(Post post);
}
