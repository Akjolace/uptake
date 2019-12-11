package edu.mum.cs544.a4.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "following")
public class Following {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne()
    @Column(name = "following_user_id")
    private User followingUser;

    @ManyToOne()
    @Column(name = "follower_user_id")
    private User followerUser;

    @Column(name = "created")
    private LocalDate created;

}
