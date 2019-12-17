package edu.mum.cs544.a4.entity.onoko;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PostForNewsfeed{

    @Id
    private Long id;

    private String description;

    private String username;

    private String postPath;

    private String profilePath;

    public String getPostPath() {
        return this.postPath;
    }

    public void setPostPath(String postPath) {
        this.postPath = postPath;
    }

    public String getProfilePath() {
        return this.profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }


    private LocalDate created;

    public PostForNewsfeed(){}

    public PostForNewsfeed(String description, String username, String postPath, String profilePath, LocalDate created ){
        this.description = description;
        this.username = username;
        this.postPath = postPath;
        this.profilePath = profilePath;
        this.created = created;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getCreated() {
        return this.created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }
}