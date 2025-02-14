package com.campuslands.Mi_Red_Social.entities.dto;

import java.sql.Timestamp;

public class FollowerDTO {
    private Integer id;
    private Timestamp created_at;
    private Integer user_follower_id;
    private Integer user_following_id;

    public FollowerDTO(){}

    public FollowerDTO(Integer id, Timestamp created_at, Integer user_follower, Integer user_following) {
        this.id = id;
        this.created_at = created_at;
        this.user_follower_id = user_follower;
        this.user_following_id = user_following;
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

    public Integer getUser_follower_id() {
        return user_follower_id;
    }

    public void setUser_follower_id(Integer user_follower_id) {
        this.user_follower_id = user_follower_id;
    }

    public Integer getUser_following_id() {
        return user_following_id;
    }

    public void setUser_following_id(Integer user_following_id) {
        this.user_following_id = user_following_id;
    }

    @Override
    public String toString() {
        return "FollowerDTO{" +
                "id=" + id +
                ", created_at=" + created_at +
                ", user_follower=" + user_follower_id +
                ", user_following=" + user_following_id +
                '}';
    }
}
