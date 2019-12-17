package edu.mum.cs544.a4.service.impl;

import edu.mum.cs544.a4.entity.Comment;
import edu.mum.cs544.a4.entity.Post;
import edu.mum.cs544.a4.entity.User;
import edu.mum.cs544.a4.repository.CommentRepository;
import edu.mum.cs544.a4.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment add(User user, Post post, String description) {
        return commentRepository.save(new Comment(post,user,description));
    }
}
