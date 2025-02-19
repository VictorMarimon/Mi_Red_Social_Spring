package com.campuslands.Mi_Red_Social.entities.dto;

import java.sql.Date;
import java.util.List;

public class PostsDTO {
    private Integer id;
    private String content;
    private Date created_at;
    private Integer user_posts_id;
    private List<ImagesPostDTO> images;  // Agregar imágenes
    private List<TagsPostDTO> tags;

    public PostsDTO(){}

    public PostsDTO(Integer id, String content, Date created_at, Integer user_posts_id, List<ImagesPostDTO> images, List<TagsPostDTO> tags) {
        this.id = id;
        this.content = content;
        this.created_at = created_at;
        this.user_posts_id = user_posts_id;
        this.images = images;
        this.tags = tags;
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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Integer getUser_posts_id() {
        return user_posts_id;
    }

    public void setUser_posts_id(Integer user_posts_id) {
        this.user_posts_id = user_posts_id;
    }

    public List<ImagesPostDTO> getImages() {
        return images;
    }

    public void setImages(List<ImagesPostDTO> images) {
        this.images = images;
    }

    public List<TagsPostDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagsPostDTO> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "PostsDTO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created_at=" + created_at +
                ", user_posts_id=" + user_posts_id +
                ", images=" + images +
                ", tags=" + tags +
                '}';
    }
}
