package com.campuslands.Mi_Red_Social.entities;

import jakarta.persistence.*;
import jakarta.websocket.ClientEndpoint;

import java.sql.Timestamp;

@Entity
@Table(name = "followers")
public class FollowersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "created_at")
    private Timestamp created_at;

    @ManyToOne
    @JoinColumn(name = "follower_id")
    private UserEntity user_follower;

    @ManyToOne
    @JoinColumn(name = "following_id")
    private UserEntity user_following;

    public FollowersEntity(){}

    public FollowersEntity(Integer id, Timestamp created_at, UserEntity user_follower, UserEntity user_following) {
        this.id = id;
        this.created_at = created_at;
        this.user_follower = user_follower;
        this.user_following = user_following;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public UserEntity getUser_follower() {
        return user_follower;
    }

    public void setUser_follower(UserEntity user_follower) {
        this.user_follower = user_follower;
    }

    public UserEntity getUser_following() {
        return user_following;
    }

    public void setUser_following(UserEntity user_following) {
        this.user_following = user_following;
    }

    @Override
    public String toString() {
        return "FollowersEntity{" +
                "id=" + id +
                ", created_at=" + created_at +
                ", user_follower=" + user_follower +
                ", user_following=" + user_following +
                '}';
    }
}
