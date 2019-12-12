package edu.mum.cs544.a4.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String advertisementUrl;
    private LocalDateTime created;
    private int status=1;
    private int targetAgeMin;
    private int targetAgeMax;

    @ManyToOne
    private Country targetCountry;

    private Gender targetGender;
    @ManyToOne
    private Photo photo;

    @ManyToOne
    private User user;

}
