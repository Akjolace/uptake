package edu.mum.cs544.a4.repository;


import edu.mum.cs544.a4.entity.Follower;
import edu.mum.cs544.a4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends JpaRepository<Follower, Long> {
    @Query(value="select case when count(f.id)> 0 then true else false end as isfollowing from uptake.follower f where f.followed_user_id= :A and f.following_user_id = :B",nativeQuery = true)
    boolean isAfollowingB(@Param("A") long A, @Param("B") long B);
}
