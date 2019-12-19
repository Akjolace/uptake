package edu.mum.cs544.a4.service.impl;

import edu.mum.cs544.a4.entity.Post;
import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.repository.PostRepository;
import edu.mum.cs544.a4.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Long addPost(Post post) {
        postRepository.save(post);
        return post.getId();
    }

    @Override
    public Long editPost(Post post) {
        postRepository.save(post);
        return post.getId();
    }

    public Post findPostById(long id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

//    @Override
    public Page<Post> getAllByUser(User user, Pageable pageable) {
        return postRepository.findAllByUser(user,pageable);
    }

    public Page<Post> getAllPosts(Pageable pageable){
        return postRepository.findAll(pageable);
    }

//    @Override
//    public List<Post> getAllPostByPage(Pageable page) {
//        return postRepository(page);

    @Override
    public int countUnhealthyPost(long userId) {
        return postRepository.countUnhealthyByUserId(userId);
    }
}
