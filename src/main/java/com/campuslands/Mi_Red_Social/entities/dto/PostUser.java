package com.campuslands.Mi_Red_Social.entities.dto;

import java.sql.Date;

public class PostUser {
    private Integer id;
    private String content;
    private String image;
    private String tag;
    private Date created_at;
    private Long comment;
    private Long like;

    public PostUser(){}

    public PostUser(Integer id, String content, String image, String tag, Date created_at, Long comment, Long like) {
        this.id = id;
        this.content = content;
        this.image = image;
        this.tag = tag;
        this.created_at = created_at;
        this.comment = comment;
        this.like = like;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Long getComment() {
        return comment;
    }

    public void setComment(Long comment) {
        this.comment = comment;
    }

    public Long getLike() {
        return like;
    }

    public void setLike(Long like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return "PostUser{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", tag='" + tag + '\'' +
                ", created_at=" + created_at +
                ", comment=" + comment +
                ", like=" + like +
                '}';
    }
}
