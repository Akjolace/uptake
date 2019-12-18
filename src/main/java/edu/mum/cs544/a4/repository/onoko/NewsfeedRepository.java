package edu.mum.cs544.a4.repository.onoko;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import edu.mum.cs544.a4.entity.onoko.PostForNewsfeed;

public interface NewsfeedRepository extends PagingAndSortingRepository<PostForNewsfeed, Long>{

    String queryString = "select "
    + " post.id, post.description, user.username, "
    + " photo.path as post_path,  "
    + " photoProfile.path as profile_path, "
    + " post.created "
    + " from post post "
    + " left join photo photo on post.photo_id = photo.id "
    + " left join user user on post.user_id = user.id "
    + " left join profile profile on post.user_id = profile.user_id "
    + " left join photo photoProfile on profile.photo_id = photoProfile.id "
    + " where post.user_id in ( select f.followed_user_id "
    + " from follower f "
    + " inner join user u ON F.following_user_id = u.id"
    + " where u.email = :email ) or user.email = :email "
    + " order by post.created desc ";

    @Query( value= queryString, nativeQuery = true )
    List<PostForNewsfeed> getNewsfeedByEmail(@Param("email") String email, Pageable pageable);

    @Query( value= queryString, nativeQuery = true )
    List<PostForNewsfeed> getNewsfeedByEmail(@Param("email") String email);

    @Query( value="select count(*) from likes where post_id = :postID", nativeQuery = true )
    Long getLikeCountByPost(@Param("postID") Long postID);

    @Query( value="select count(*) from comment where post_id = :postID", nativeQuery = true )
    Long getCommentCountByPost(@Param("postID") Long postID);



}