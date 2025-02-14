package com.campuslands.Mi_Red_Social.entities.dto;

public class TagDTO {
    private Integer id;
    private String tag;
    private Integer post_tag_id;

    public TagDTO(){}

    public TagDTO(Integer id, String tag, Integer post_tag_id) {
        this.id = id;
        this.tag = tag;
        this.post_tag_id = post_tag_id;
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

    public Integer getPost_tag_id() {
        return post_tag_id;
    }

    public void setPost_tag_id(Integer post_tag_id) {
        this.post_tag_id = post_tag_id;
    }

    @Override
    public String toString() {
        return "TagDTO{" +
                "id=" + id +
                ", tag='" + tag + '\'' +
                ", post_tag_id=" + post_tag_id +
                '}';
    }
}
