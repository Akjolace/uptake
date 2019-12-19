package edu.mum.cs544.a4.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Ads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "{errorMsg.post.title}")
    private String title;
    @NotEmpty(message = "{errorMsg.post.description}")
    private String description;
    @NotEmpty(message = "{errorMsg.ads.advertisementUrl}")
    private String advertisementUrl;
    private LocalDateTime created;
    private int status = 1;
    @Min(value=1,message = "{errorMsg.ads.targetAgeMin}")
    private int targetAgeMin;
    @Min(value=1,message = "{errorMsg.ads.targetAgeMax}")
    private int targetAgeMax;

    @ManyToOne(cascade=CascadeType.ALL)
    private Country targetCountry;

    @NotNull(message = "{errorMsg.ads.gender}")
    private Gender targetGender;
    @ManyToOne(cascade=CascadeType.ALL)
    private Photo photo;

    @ManyToOne(cascade=CascadeType.ALL)
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

    @Override
    public String toString() {
        return "Ads{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", advertisementUrl='" + advertisementUrl + '\'' +
                ", created=" + created +
                ", status=" + status +
                ", targetAgeMin=" + targetAgeMin +
                ", targetAgeMax=" + targetAgeMax +
                ", targetCountry=" + targetCountry +
                ", targetGender=" + targetGender +
                ", photo=" + photo +
                ", user=" + user +
                '}';
    }
}

