package com.campuslands.Mi_Red_Social.entities.dto;

import java.sql.Timestamp;

public class PostsDTO {
    private Integer id;
    private String content;
    private Timestamp created_at;
    private Integer user_posts_id;

    public PostsDTO(){}

    public PostsDTO(Integer id, String content, Timestamp created_at, Integer user_posts_id) {
        this.id = id;
        this.content = content;
        this.created_at = created_at;
        this.user_posts_id = user_posts_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Integer getUser_posts_id() {
        return user_posts_id;
    }

    public void setUser_posts_id(Integer user_posts_id) {
        this.user_posts_id = user_posts_id;
    }

    @Override
    public String toString() {
        return "PostsDTO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created_at=" + created_at +
                ", user_posts_id=" + user_posts_id +
                '}';
    }
}
