package edu.mum.cs544.a4.repository;

import edu.mum.cs544.a4.entity.Profile;
import edu.mum.cs544.a4.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);

    User findByEmail(String email);

    User findByUsername(String username);

    User findByPublicName(String userName);

    @Query(value = "update uptake.user u set u.status = 0 where u.id= :userId", nativeQuery = true)
    boolean deactivateUser(@Param("userId") long userId);
}
