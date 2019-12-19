package edu.mum.cs544.a4.repository;

import edu.mum.cs544.a4.entity.Post;

import java.util.List;

import edu.mum.cs544.a4.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Post findById(long id);
//    Page<Post> findAllByUser(User user, Pageable pageable);
    Page<Post> findAllByUser(User user, Pageable pageable);
    Page<Post> findAll(Pageable pageable);

    //String queryForFindByDescription = " select p from Post p  ";
    
    //@Query(value = queryForFindByDescription, nativeQuery = true)
    //List<Post> findByDescription(String email, String description);

}
