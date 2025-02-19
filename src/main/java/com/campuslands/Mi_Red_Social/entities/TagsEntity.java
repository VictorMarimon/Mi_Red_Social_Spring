package com.campuslands.Mi_Red_Social.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "posts_tags")
public class TagsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "tag")
    private String tag;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "posts_id")
    private PostsEntity post_tags;

    public TagsEntity(){}

    public TagsEntity(Integer id, String tag, PostsEntity post_tags) {
        this.id = id;
        this.tag = tag;
        this.post_tags = post_tags;
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

    public PostsEntity getPost_tags() {
        return post_tags;
    }

    public void setPost_tags(PostsEntity post_tags) {
        this.post_tags = post_tags;
    }

    @Override
    public String toString() {
        return "TagsEntity{" +
                "id=" + id +
                ", tag='" + tag + '\'' +
                ", post_tags=" + post_tags +
                '}';
    }
}
