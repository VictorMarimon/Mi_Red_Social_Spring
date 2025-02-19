package com.campuslands.Mi_Red_Social.entities.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class PostsFollowingUserDTO {
    private Integer id;
    private String name;
    private String username;
    private String photo_profile;
    private String content;
    private Date createdAt;
    private Long like_count;
    private Long comment_count;
    private List<String> images;
    private List<String> tags;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public PostsFollowingUserDTO(){}

    public PostsFollowingUserDTO(Integer id, String name, String username, String photo_profile, String content,
                                 Date createdAt, Long like_count, Long comment_count,
                                 String imagesJson, String tagsJson) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.photo_profile = photo_profile;
        this.content = content;
        this.createdAt = createdAt;
        this.like_count = like_count;
        this.comment_count = comment_count;
        this.images = convertJsonToList(imagesJson);
        this.tags = convertJsonToList(tagsJson);
    }

    private List<String> convertJsonToList(String json) {
        try {
            return (json != null && !json.isEmpty()) ?
                    objectMapper.readValue(json, new TypeReference<List<String>>() {}) : new ArrayList<>();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getLike_count() {
        return like_count;
    }

    public void setLike_count(Long like_count) {
        this.like_count = like_count;
    }

    public Long getComment_count() {
        return comment_count;
    }

    public void setComment_count(Long comment_count) {
        this.comment_count = comment_count;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "PostsFollowingUserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", photo_profile='" + photo_profile + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", like_count=" + like_count +
                ", comment_count=" + comment_count +
                ", images=" + images +
                ", tags=" + tags +
                '}';
    }
}
