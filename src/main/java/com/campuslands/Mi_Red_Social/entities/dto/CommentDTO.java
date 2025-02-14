package com.campuslands.Mi_Red_Social.entities.dto;

import java.sql.Timestamp;

public class CommentDTO {
    private Integer id;
    private String comment;
    private Timestamp created_at;
    private Integer user_comment_id;
    private Integer post_comment_id;

    public CommentDTO(){}

    public CommentDTO(Integer id, String comment, Timestamp created_at, Integer user_comment_id, Integer post_comment_id) {
        this.id = id;
        this.comment = comment;
        this.created_at = created_at;
        this.user_comment_id = user_comment_id;
        this.post_comment_id = post_comment_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Integer getUser_comment_id() {
        return user_comment_id;
    }

    public void setUser_comment_id(Integer user_comment_id) {
        this.user_comment_id = user_comment_id;
    }

    public Integer getPost_comment_id() {
        return post_comment_id;
    }

    public void setPost_comment_id(Integer post_comment_id) {
        this.post_comment_id = post_comment_id;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", created_at=" + created_at +
                ", user_comment_id=" + user_comment_id +
                ", post_comment_id=" + post_comment_id +
                '}';
    }
}
