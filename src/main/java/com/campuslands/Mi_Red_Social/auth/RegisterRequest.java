package com.campuslands.Mi_Red_Social.auth;

import com.campuslands.Mi_Red_Social.role.Role;

import java.sql.Date;

public class RegisterRequest {
    String name;
    String username;
    String email;
    String phone_number;
    String photo_profile;
    String biography;
    String password;
    Date created_at;
    Date birthday;
    Role rol;

    public RegisterRequest(){}

    public RegisterRequest(String name, String username, String email, String phone, String photo, String biography, String password, Date created_at, Date birthday, Role rol) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone_number = phone;
        this.photo_profile = photo;
        this.biography = biography;
        this.password = password;
        this.created_at = created_at;
        this.birthday = birthday;
        this.rol = rol;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPhoto_profile() {
        return photo_profile;
    }

    public void setPhoto_profile(String photo_profile) {
        this.photo_profile = photo_profile;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Role getRol() {
        return rol != null ? rol : Role.USER;
    }

    public void setRol(Role rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone_number + '\'' +
                ", photo='" + photo_profile + '\'' +
                ", biography='" + biography + '\'' +
                ", password='" + password + '\'' +
                ", created_at=" + created_at +
                ", birthday=" + birthday +
                ", rol=" + rol +
                '}';
    }
}
