package edu.mum.cs544.a4.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Ads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String advertisementUrl;
    private LocalDateTime created;
    private int status = 1;
    private int targetAgeMin;
    private int targetAgeMax;

    @ManyToOne
    private Country targetCountry;

    private Gender targetGender;
    @ManyToOne
    private Photo photo;

    @ManyToOne
    private User user;

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

    public String getAdvertisementUrl() {
        return advertisementUrl;
    }

    public void setAdvertisementUrl(String advertisementUrl) {
        this.advertisementUrl = advertisementUrl;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTargetAgeMin() {
        return targetAgeMin;
    }

    public void setTargetAgeMin(int targetAgeMin) {
        this.targetAgeMin = targetAgeMin;
    }

    public int getTargetAgeMax() {
        return targetAgeMax;
    }

    public void setTargetAgeMax(int targetAgeMax) {
        this.targetAgeMax = targetAgeMax;
    }

    public Country getTargetCountry() {
        return targetCountry;
    }

    public void setTargetCountry(Country targetCountry) {
        this.targetCountry = targetCountry;
    }

    public Gender getTargetGender() {
        return targetGender;
    }

    public void setTargetGender(Gender targetGender) {
        this.targetGender = targetGender;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
