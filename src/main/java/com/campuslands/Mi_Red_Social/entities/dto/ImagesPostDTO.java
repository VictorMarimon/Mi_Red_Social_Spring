package com.campuslands.Mi_Red_Social.entities.dto;

public class ImagesPostDTO {
    private Integer id;
    private String image;

    public ImagesPostDTO(){}

    public ImagesPostDTO(Integer id, String image) {
        this.id = id;
        this.image = image;
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

    @Override
    public String toString() {
        return "ImagesPostDTO{" +
                "id=" + id +
                ", image='" + image + '\'' +
                '}';
    }
}
