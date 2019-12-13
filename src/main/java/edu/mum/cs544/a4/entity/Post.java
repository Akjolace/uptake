package edu.mum.cs544.a4.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime created;
    private Boolean isUnhealthy = false;
    private int status = 1;
    @ManyToOne
    private Photo photo;

    @OneToMany(mappedBy = "post")
    private List<Comment> commentList = new ArrayList<>();

    @ManyToOne
    private User user;

    @OneToMany
    private List<Like> likeList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Boolean getUnhealthy() {
        return isUnhealthy;
    }

    public void setUnhealthy(Boolean unhealthy) {
        isUnhealthy = unhealthy;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public List<Comment> getCommentList() {
        return commentList != null ? this.commentList : (this.commentList = new ArrayList<>());
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Like> getLikeList() {
        return likeList != null ? this.likeList : (this.likeList = new ArrayList<>());
    }

    public void setLikeList(List<Like> likeList) {
        this.likeList = likeList;
    }
}