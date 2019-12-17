package edu.mum.cs544.a4.repository.onoko;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.a4.entity.onoko.UserForSearch;

@Repository
public interface UserForSearchRepository extends JpaRepository<UserForSearch, Long>{

    @Query(value="select distinct u.username, p.bio, i.path from user u inner join profile p on u.id = p.user_id left join photo i on p.photo_id = i.id  where u.username like %"+ ":username" +"% limit 10;", nativeQuery = true)
    List<UserForSearch> findTop10UsersByUsername(@Param("username") String username);

}