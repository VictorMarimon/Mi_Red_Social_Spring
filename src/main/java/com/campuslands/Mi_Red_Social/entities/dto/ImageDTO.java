package com.campuslands.Mi_Red_Social.entities.dto;


public class ImageDTO {
    private Integer id;
    private String image;
    private Integer post_image_id;

    public ImageDTO(){}

    public ImageDTO(Integer id, String image, Integer post_image_id) {
        this.id = id;
        this.image = image;
        this.post_image_id = post_image_id;
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

    public Integer getPost_image_id() {
        return post_image_id;
    }

    public void setPost_image_id(Integer post_image_id) {
        this.post_image_id = post_image_id;
    }

    @Override
    public String toString() {
        return "ImageDTO{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", post_image_id=" + post_image_id +
                '}';
    }
}
