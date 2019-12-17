package edu.mum.cs544.a4.repository;


import edu.mum.cs544.a4.entity.Comment;
import edu.mum.cs544.a4.entity.Post;
import edu.mum.cs544.a4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}