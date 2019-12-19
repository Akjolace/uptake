package edu.mum.cs544.a4.entity;

import javax.persistence.*;

@Entity
@Table(name = "follower")
public class Follower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="following_user_id")
    private User followingUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="followed_user_id")
    private User followedUser;

    public Follower() {
    }

    public Follower(User followingUser, User followedUser) {
        this.followingUser = followingUser;
        this.followedUser = followedUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getFollowingUser() {
        return followingUser;
    }

    public void setFollowingUser(User followingUser) {
        this.followingUser = followingUser;
    }

    public User getFollowedUser() {
        return followedUser;
    }

    public void setFollowedUser(User followedUser) {
        this.followedUser = followedUser;
    }
}
