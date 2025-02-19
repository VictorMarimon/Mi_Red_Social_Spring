package com.campuslands.Mi_Red_Social.entities.dto;

import java.sql.Date;

public class CommentPostDTO {
    private Integer id;
    private String comment;
    private Date created_at;
    private String username;
    private String photo_profile;

    public CommentPostDTO(){}

    public CommentPostDTO(Integer id, String comment, Date created_at, String username, String photo_profile) {
        this.id = id;
        this.comment = comment;
        this.created_at = created_at;
        this.username = username;
        this.photo_profile = photo_profile;
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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoto_profile() {
        return photo_profile;
    }

    public void setPhoto_profile(String photo_profile) {
        this.photo_profile = photo_profile;
    }

    @Override
    public String toString() {
        return "CommentPostDTO{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", created_at=" + created_at +
                ", username='" + username + '\'' +
                ", photo_profile='" + photo_profile + '\'' +
                '}';
    }
}
