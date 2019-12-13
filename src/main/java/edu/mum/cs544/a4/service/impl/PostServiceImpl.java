package edu.mum.cs544.a4.service.impl;

import edu.mum.cs544.a4.entity.Post;
import edu.mum.cs544.a4.repository.PostRepository;
import edu.mum.cs544.a4.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Long addPost(Post post) {
        postRepository.save(post);
        return post.getId();
    }

    public Post findPostById(long id) {
        return postRepository.findById(id);
    }
}
