package com.campuslands.Mi_Red_Social.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "type_interaction")
public class TypeInteractionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "type_like")
    private List<LikesEntity> likes;

    public TypeInteractionEntity(){}

    public TypeInteractionEntity(Integer id, String type, List<LikesEntity> likes) {
        this.id = id;
        this.type = type;
        this.likes = likes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<LikesEntity> getLikes() {
        return likes;
    }

    public void setLikes(List<LikesEntity> likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "TypeInteractionEntity{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", likes=" + likes +
                '}';
    }
}
