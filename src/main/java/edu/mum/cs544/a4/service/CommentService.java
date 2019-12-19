package edu.mum.cs544.a4.service;

import edu.mum.cs544.a4.entity.Comment;
import edu.mum.cs544.a4.entity.Post;
import edu.mum.cs544.a4.entity.User;

import java.util.List;

public interface CommentService {
    Comment add(User user, Post post, String description);
    List<Comment> getAllByUser(User user);
    List<Comment> findAllComments();
}
