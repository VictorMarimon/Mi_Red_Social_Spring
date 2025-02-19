package com.campuslands.Mi_Red_Social.entities.dto;

public class TagsPostDTO {
    private Integer id;
    private String tag;

    public TagsPostDTO(){}

    public TagsPostDTO(Integer id, String tag) {
        this.id = id;
        this.tag = tag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "TagsPostDTO{" +
                "id=" + id +
                ", tag='" + tag + '\'' +
                '}';
    }
}
