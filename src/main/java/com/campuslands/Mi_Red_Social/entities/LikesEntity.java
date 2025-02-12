package com.campuslands.Mi_Red_Social.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "likes")
public class LikesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "active")
    private boolean active;
    @Column(name = "created_at")
    private Timestamp created_at;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user_likes;

    @ManyToOne
    @JoinColumn(name = "posts_id")
    private PostsEntity post_likes;

    @ManyToOne
    @JoinColumn(name = "type_interaction_id")
    private TypeInteractionEntity type_like;

    public LikesEntity(){}

    public LikesEntity(Integer id, boolean active, Timestamp created_at, UserEntity user_likes, PostsEntity post_likes, TypeInteractionEntity type_like) {
        this.id = id;
        this.active = active;
        this.created_at = created_at;
        this.user_likes = user_likes;
        this.post_likes = post_likes;
        this.type_like = type_like;
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

    public UserEntity getUser_likes() {
        return user_likes;
    }

    public void setUser_likes(UserEntity user_likes) {
        this.user_likes = user_likes;
    }

    public PostsEntity getPost_likes() {
        return post_likes;
    }

    public void setPost_likes(PostsEntity post_likes) {
        this.post_likes = post_likes;
    }

    public TypeInteractionEntity getType_like() {
        return type_like;
    }

    public void setType_like(TypeInteractionEntity type_like) {
        this.type_like = type_like;
    }

    @Override
    public String toString() {
        return "LikesEntity{" +
                "id=" + id +
                ", active=" + active +
                ", created_at=" + created_at +
                ", user_likes=" + user_likes +
                ", post_likes=" + post_likes +
                ", type_like=" + type_like +
                '}';
    }
}
