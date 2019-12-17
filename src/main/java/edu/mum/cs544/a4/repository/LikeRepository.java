package edu.mum.cs544.a4.repository;


import edu.mum.cs544.a4.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    @Query(value = "select case when count(l.id)> 0 then true else false end as isliked from uptake.likes l where l.user_id= :A and l.post_id = :B", nativeQuery = true)
    int isALikedB(@Param("A") long A, @Param("B") long B);
}