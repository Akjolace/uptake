package edu.mum.cs544.a4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.mum.cs544.a4.entity.NotificationUser;

public interface NotificationUserRepository extends JpaRepository<NotificationUser, Long>{

    @Query("select n from NotificationUser n where n.destinationUserEmail = :email")
    public List<NotificationUser> findByDestinationUserEmail(@Param("email") String email);    

    @Query("select n from NotificationUser n where n.id = :id ")
    public NotificationUser myFindById(@Param("id") long id);
}