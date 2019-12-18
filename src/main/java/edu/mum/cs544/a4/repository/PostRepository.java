package edu.mum.cs544.a4.repository;

import edu.mum.cs544.a4.entity.Post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Post findById(long id);
    
    @Query(value = "", nativeQuery = true)
    List<Post> findByDescription(String email, String description);

}
