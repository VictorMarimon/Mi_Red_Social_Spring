package com.campuslands.Mi_Red_Social.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "posts")
public class PostsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "content")
    private String content;
    @Column(name = "created_at")
    private Timestamp created_at;

    @OneToMany(mappedBy = "post_comments")
    @JsonIgnore
    private List<CommentsEntity> postComments;

    @OneToMany(mappedBy = "post_likes")
    @JsonIgnore
    private List<LikesEntity> postLikes;

    @OneToMany(mappedBy = "post_tags")
    @JsonIgnore
    private List<TagsEntity> postTags;

    @OneToMany(mappedBy = "post_images")
    @JsonIgnore
    private List<ImagesEntity> postImages;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user_posts;

    public PostsEntity(){}

    public PostsEntity(Integer id, String content, Timestamp created_at, List<CommentsEntity> postComments, List<LikesEntity> postLikes, List<TagsEntity> postTags, List<ImagesEntity> postImages, UserEntity user_posts) {
        this.id = id;
        this.content = content;
        this.created_at = created_at;
        this.postComments = postComments;
        this.postLikes = postLikes;
        this.postTags = postTags;
        this.postImages = postImages;
        this.user_posts = user_posts;
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

    public List<CommentsEntity> getPostComments() {
        return postComments;
    }

    public void setPostComments(List<CommentsEntity> postComments) {
        this.postComments = postComments;
    }

    public List<LikesEntity> getPostLikes() {
        return postLikes;
    }

    public void setPostLikes(List<LikesEntity> postLikes) {
        this.postLikes = postLikes;
    }

    public List<TagsEntity> getPostTags() {
        return postTags;
    }

    public void setPostTags(List<TagsEntity> postTags) {
        this.postTags = postTags;
    }

    public List<ImagesEntity> getPostImages() {
        return postImages;
    }

    public void setPostImages(List<ImagesEntity> postImages) {
        this.postImages = postImages;
    }

    public UserEntity getUser_posts() {
        return user_posts;
    }

    public void setUser_posts(UserEntity user_posts) {
        this.user_posts = user_posts;
    }

    @Override
    public String toString() {
        return "PostsEntity{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created_at=" + created_at +
                ", postComments=" + postComments +
                ", postLikes=" + postLikes +
                ", postTags=" + postTags +
                ", postImages=" + postImages +
                ", user_posts=" + user_posts +
                '}';
    }
}
