package com.campuslands.Mi_Red_Social.entities.dto;

import java.sql.Timestamp;

public class LikeDTO {
    private Integer id;
    private boolean active;
    private Timestamp created_at;
    private Integer user_like_id;
    private Integer post_like_id;
    private Integer type_like_id;

    public LikeDTO(){}

    public LikeDTO(Integer id, boolean active, Timestamp created_at, Integer user_like_id, Integer post_like_id, Integer type_like_id) {
        this.id = id;
        this.active = active;
        this.created_at = created_at;
        this.user_like_id = user_like_id;
        this.post_like_id = post_like_id;
        this.type_like_id = type_like_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Integer getUser_like_id() {
        return user_like_id;
    }

    public void setUser_like_id(Integer user_like_id) {
        this.user_like_id = user_like_id;
    }

    public Integer getPost_like_id() {
        return post_like_id;
    }

    public void setPost_like_id(Integer post_like_id) {
        this.post_like_id = post_like_id;
    }

    public Integer getType_like_id() {
        return type_like_id;
    }

    public void setType_like_id(Integer type_like_id) {
        this.type_like_id = type_like_id;
    }

    @Override
    public String toString() {
        return "LikeDTO{" +
                "id=" + id +
                ", active=" + active +
                ", created_at=" + created_at +
                ", user_like_id=" + user_like_id +
                ", post_like_id=" + post_like_id +
                ", type_like_id=" + type_like_id +
                '}';
    }
}
