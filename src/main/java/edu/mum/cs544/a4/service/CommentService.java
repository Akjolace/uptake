package edu.mum.cs544.a4.service;

import edu.mum.cs544.a4.entity.Comment;
import edu.mum.cs544.a4.entity.Post;
import edu.mum.cs544.a4.entity.User;

public interface CommentService {
    Comment add(User user, Post post, String description);
}
