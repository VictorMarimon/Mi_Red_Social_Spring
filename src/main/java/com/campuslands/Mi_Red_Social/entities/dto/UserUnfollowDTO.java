package com.campuslands.Mi_Red_Social.entities.dto;

public class UserUnfollowDTO {
    private Integer id;
    private String name;
    private String username;
    private String photo_profile;

    public UserUnfollowDTO(){}

    public UserUnfollowDTO(Integer id, String name, String username, String photo_profile) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.photo_profile = photo_profile;
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

    @Override
    public String toString() {
        return "UserUnfollowDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", photo_profile='" + photo_profile + '\'' +
                '}';
    }
}
