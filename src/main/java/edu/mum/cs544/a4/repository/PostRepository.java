package edu.mum.cs544.a4.repository;

import edu.mum.cs544.a4.entity.Post;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Post findById(long id);

    //String queryForFindByDescription = " select p from Post p  ";
    
    //@Query(value = queryForFindByDescription, nativeQuery = true)
    //List<Post> findByDescription(String email, String description);

    @Query(value = "select count(p.id) from uptake.post p where p.user_id= :userId and p.is_unhealthy=1", nativeQuery = true)
    int countUnhealthyByUserId(@Param("userId") long userId);


}
