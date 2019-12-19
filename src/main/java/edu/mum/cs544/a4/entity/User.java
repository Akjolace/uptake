package edu.mum.cs544.a4.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import edu.mum.cs544.a4.entity.Follower;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Email
    @NotBlank
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank
    @Size(min = 6)
    private String password;

    @Transient
    private String passwordConfirm;

    @CreatedDate
    private LocalDate createdDate;

    private boolean status;

    private String publicName;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "followedUser")
    @LazyCollection(LazyCollectionOption.EXTRA)
    private List<Follower> followedUsers;

    @JsonIgnore
    @OneToMany(mappedBy = "followingUser")
    @LazyCollection(LazyCollectionOption.EXTRA)
    private List<Follower> followingUser;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id")})
    @JsonIgnore
    private List<Role> role;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    @LazyCollection(value = LazyCollectionOption.EXTRA)
    private List<Post> postList;

    @OneToOne(mappedBy = "user", cascade = CascadeType.PERSIST)
    private Profile profile;

    public User() {
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPublicName() {
        return publicName;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Role> getRole() {
        return role != null ? this.role : (this.role = new ArrayList<>());
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public List<Post> getPostList() {
        return postList != null ? this.postList : (this.postList = new ArrayList<>());
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Follower> getFollowedUsers() {
        return followedUsers;
    }

    public void setFollowedUsers(List<Follower> followedUsers) {
        this.followedUsers = followedUsers;
    }

    public List<Follower> getFollowingUser() {
        return followingUser;
    }

    public void setFollowingUser(List<Follower> followingUser) {
        this.followingUser = followingUser;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\'' + ", email='" + email + '\'' + '}';
    }

}
