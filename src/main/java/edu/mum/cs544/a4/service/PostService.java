package edu.mum.cs544.a4.service;

import edu.mum.cs544.a4.entity.Post;
import edu.mum.cs544.a4.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    Long addPost(Post post);

    Long editPost(Post post);

    Post findPostById(long id);

    public List<Post> getAllPost();

    Page<Post> getAllByUser(User user, Pageable pageable);

    Page<Post> getAllPosts(Pageable pageable);

    int countUnhealthyPost(long userId);
}
