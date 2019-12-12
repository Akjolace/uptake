package edu.mum.cs544.a4.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    //@Column(name = "first_name")
    //private String firstName;
    //@Column(name = "last_name")
    //private String lastName;

    @Column(name = "email")
    private String email;

    private String password;

    @Transient
    private String passwordConfirm;

    private LocalDate createdDate;

    private boolean status;

    @OneToOne
    private Address address;

    @ManyToMany
    @JoinTable(name = "user_role",  
        joinColumns = {@JoinColumn(name = "user_id", referencedColumnName="id")}, 
        inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName="id")})
    private List<Role> role = new ArrayList<>();

    @OneToMany(mappedBy = "followingUser")
    @Column(name = "following_User")
    private List<Following> followingUserList;

    @OneToMany(mappedBy = "followerUser")
    @Column(name = "follower_User")
    private List<Following> followerUserList;

    @OneToMany(mappedBy = "user")
    private List<Post> postList = new ArrayList<>();

    @OneToOne(mappedBy = "user")
    private Profile profile;

    public User(String fullName, String email){
        this.fullName = fullName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
