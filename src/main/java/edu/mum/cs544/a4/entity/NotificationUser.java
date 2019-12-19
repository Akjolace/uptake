package edu.mum.cs544.a4.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NotificationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String profilePhotoPath;
    private String messageCode;
    private String postId;
    private Boolean hasSeen = false;
    private String destinationUserEmail;

    public NotificationUser(){};

    public NotificationUser(String username, String destinationUserEmail, String profilePhotoPath, String messageCode, String postId){
        this.username = username;
        this.profilePhotoPath = profilePhotoPath;
        this.messageCode = messageCode;
        this.postId = postId;
        this.destinationUserEmail = destinationUserEmail;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilePhotoPath() {
        return this.profilePhotoPath;
    }

    public void setProfilePhotoPath(String profilePhotoPath) {
        this.profilePhotoPath = profilePhotoPath;
    }

    public String getMessageCode() {
        return this.messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getPostId() {
        return this.postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public Boolean getHasSeen() {
        return this.hasSeen;
    }

    public void isHasSeen(Boolean hasSeen) {
        this.hasSeen = hasSeen;
    }

    public String getDestinationUserEmail() {
        return this.destinationUserEmail;
    }

    public void setDestinationUserEmail(String destinationUserEmail) {
        this.destinationUserEmail = destinationUserEmail;
    }

}