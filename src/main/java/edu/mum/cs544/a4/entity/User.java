package edu.mum.cs544.a4.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
    @Column(name = "email")
    private String email;

    private String password;

    @Transient
    private String passwordConfirm;

    private LocalDate createdDate;

    private boolean status;

    private String publicName;

    @OneToOne
    private Address address;

    @ManyToMany
    @JoinTable(name = "user_role",  
        joinColumns = {@JoinColumn(name = "user_id", referencedColumnName="id")}, 
        inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName="id")})
    private List<Role> role = new ArrayList<>();

    @OneToMany(mappedBy = "followingUser", cascade = CascadeType.PERSIST)
    @Column(name = "following_User")
    @LazyCollection(value = LazyCollectionOption.EXTRA)
    private List<Following> followingUserList;

    @OneToMany(mappedBy = "followerUser")
    @Column(name = "follower_User")
    @LazyCollection(value = LazyCollectionOption.EXTRA)
    private List<Following> followerUserList;

    @OneToMany(mappedBy = "user")
    @LazyCollection(value = LazyCollectionOption.EXTRA)
    private List<Post> postList = new ArrayList<>();

    @OneToOne(mappedBy = "user")
    private Profile profile;

    public User(String email){
        this.email = email;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }

    public void addFollowing(Following followingUser){
        if(this.followingUserList.size()==0){
            this.followingUserList = new ArrayList<>();
        }
        this.followingUserList.add(followingUser);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public List<Following> getFollowingUserList() {
        return followingUserList;
    }

    public void setFollowingUserList(List<Following> followingUserList) {
        this.followingUserList = followingUserList;
    }

    public List<Following> getFollowerUserList() {
        return followerUserList;
    }

    public void setFollowerUserList(List<Following> followerUserList) {
        this.followerUserList = followerUserList;
    }

    public List<Post> getPostList() {
        return postList;
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
}
