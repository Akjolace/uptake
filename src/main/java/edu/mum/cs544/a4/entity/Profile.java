package edu.mum.cs544.a4.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="id")
    private Long id;

    private String fullName;

    private String bio;

    @Column(name = "birth_date")
    private LocalDate birhtday;

    @Column(name = "gender", length = 2)
    private Gender gender;

}
