package com.campuslands.Mi_Red_Social.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "comments")
public class CommentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "comment")
    private String comment;
    @Column(name = "created_at")
    private Timestamp created_at;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user_comments;

    @ManyToOne
    @JoinColumn(name = "posts_id")
    private PostsEntity post_comments;

    public CommentsEntity(){}

    public CommentsEntity(Integer id, String comment, Timestamp created_at, UserEntity user_comments, PostsEntity post_comments) {
        this.id = id;
        this.comment = comment;
        this.created_at = created_at;
        this.user_comments = user_comments;
        this.post_comments = post_comments;
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

    public UserEntity getUser_comments() {
        return user_comments;
    }

    public void setUser_comments(UserEntity user_comments) {
        this.user_comments = user_comments;
    }

    public PostsEntity getPost_comments() {
        return post_comments;
    }

    public void setPost_comments(PostsEntity post_comments) {
        this.post_comments = post_comments;
    }

    @Override
    public String toString() {
        return "CommentsEntity{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", created_at=" + created_at +
                ", user_comments=" + user_comments +
                ", post_comments=" + post_comments +
                '}';
    }
}
