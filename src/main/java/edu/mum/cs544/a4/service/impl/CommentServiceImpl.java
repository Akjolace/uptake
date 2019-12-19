package edu.mum.cs544.a4.service.impl;

import edu.mum.cs544.a4.entity.Comment;
import edu.mum.cs544.a4.entity.Post;
import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.repository.CommentRepository;
import edu.mum.cs544.a4.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

//    @Override
//    public Comment add(User user, Post post, String description) {
//        return commentRepository.save(new Comment(post,user,description));
//    }

    @Override
    public List<Comment> getAllByUser(User user) {
        return commentRepository.getAllByUser(user);
    }

    @Override
    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }
    public Page<Comment> getAllByPost(Post post, Pageable pageable) {
        return commentRepository.findAllByPost(post,pageable);
    }

    @Override
    public Comment add(Comment comment) {
        return commentRepository.save(comment);
    }
}
