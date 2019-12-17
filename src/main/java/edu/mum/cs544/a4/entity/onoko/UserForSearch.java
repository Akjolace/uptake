package edu.mum.cs544.a4.entity.onoko;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.Transient;

@Entity
@Transient
public class UserForSearch{

    @Id
    private String username;
    private String bio;
    private String path;

    UserForSearch(){}

    UserForSearch(String username, String bio, String path){
        this.username = username;
        this.bio = bio;
        this.path = path;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return this.bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }


}