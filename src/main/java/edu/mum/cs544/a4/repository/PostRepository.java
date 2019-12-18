package edu.mum.cs544.a4.repository;

import edu.mum.cs544.a4.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Post findById(long id);

}
