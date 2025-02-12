package com.campuslands.Mi_Red_Social.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "posts_images")
public class ImagesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "posts_id")
    private PostsEntity post_images;

    public ImagesEntity(){}

    public ImagesEntity(Integer id, String image, PostsEntity post_images) {
        this.id = id;
        this.image = image;
        this.post_images = post_images;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public PostsEntity getPost_images() {
        return post_images;
    }

    public void setPost_images(PostsEntity post_images) {
        this.post_images = post_images;
    }

    @Override
    public String toString() {
        return "ImagesEntity{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", post_images=" + post_images +
                '}';
    }
}
