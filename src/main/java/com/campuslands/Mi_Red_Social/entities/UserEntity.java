package com.campuslands.Mi_Red_Social.entities;

import com.campuslands.Mi_Red_Social.role.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phone;
    @Column(name = "password")
    private String password;
    @Column(name = "biography")
    private String biography;
    @Column(name = "photo_profile", length = 20000)
    private String photo_profile;
    @Column(name = "created_at")
    private Date created_at;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Role rol;

    @OneToMany(mappedBy = "user_sender")
    @JsonIgnore
    private List<MessageEntity> sentMessages;

    @OneToMany(mappedBy = "user_receiver")
    @JsonIgnore
    private List<MessageEntity> receivedMessages;

    @OneToMany(mappedBy = "user_follower")
    @JsonIgnore
    private List<FollowersEntity> usersFollowers;

    @OneToMany(mappedBy = "user_following")
    @JsonIgnore
    private List<FollowersEntity> usersFollowing;

    @OneToMany(mappedBy = "user_posts")
    @JsonIgnore
    private List<PostsEntity> userPosts;

    @OneToMany(mappedBy = "user_comments")
    @JsonIgnore
    private List<CommentsEntity> userComments;

    @OneToMany(mappedBy = "user_likes")
    @JsonIgnore
    private List<LikesEntity> userLikes;

    @OneToMany(mappedBy = "user_notifications")
    @JsonIgnore
    private List<NotificationEntity> notifications;

    @JsonIgnore
    private List<GrantedAuthority> authorities;

    public UserEntity(){}

    public UserEntity(Integer id, String name, String username, String email, String phone, String password, String biography, String photo_profile, Date created_at, Date birthday, Role rol, List<MessageEntity> sentMessages, List<MessageEntity> receivedMessages, List<FollowersEntity> usersFollowers, List<FollowersEntity> usersFollowing, List<PostsEntity> userPosts, List<CommentsEntity> userComments, List<LikesEntity> userLikes, List<NotificationEntity> notifications) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.biography = biography;
        this.photo_profile = photo_profile;
        this.created_at = created_at;
        this.birthday = birthday;
        this.rol = rol;
        this.sentMessages = sentMessages;
        this.receivedMessages = receivedMessages;
        this.usersFollowers = usersFollowers;
        this.usersFollowing = usersFollowing;
        this.userPosts = userPosts;
        this.userComments = userComments;
        this.userLikes = userLikes;
        this.notifications = notifications;
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

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((rol.name())));
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPhoto_profile() {
        return photo_profile;
    }

    public void setPhoto_profile(String photo_profile) {
        this.photo_profile = photo_profile;
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
        return rol!= null ? rol : Role.USER;
    }

    public void setRol(Role rol) {
        this.rol = rol;
    }

    public List<MessageEntity> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<MessageEntity> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public List<MessageEntity> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(List<MessageEntity> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }

    public List<FollowersEntity> getUsersFollowers() {
        return usersFollowers;
    }

    public void setUsersFollowers(List<FollowersEntity> usersFollowers) {
        this.usersFollowers = usersFollowers;
    }

    public List<FollowersEntity> getUsersFollowing() {
        return usersFollowing;
    }

    public void setUsersFollowing(List<FollowersEntity> usersFollowing) {
        this.usersFollowing = usersFollowing;
    }

    public List<PostsEntity> getUserPosts() {
        return userPosts;
    }

    public void setUserPosts(List<PostsEntity> userPosts) {
        this.userPosts = userPosts;
    }

    public List<CommentsEntity> getUserComments() {
        return userComments;
    }

    public void setUserComments(List<CommentsEntity> userComments) {
        this.userComments = userComments;
    }

    public List<LikesEntity> getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(List<LikesEntity> userLikes) {
        this.userLikes = userLikes;
    }

    public List<NotificationEntity> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<NotificationEntity> notifications) {
        this.notifications = notifications;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", biography='" + biography + '\'' +
                ", photo_profile='" + photo_profile + '\'' +
                ", created_at=" + created_at +
                ", birthday=" + birthday +
                ", rol=" + rol +
                ", sentMessages=" + sentMessages +
                ", receivedMessages=" + receivedMessages +
                ", usersFollowers=" + usersFollowers +
                ", usersFollowing=" + usersFollowing +
                ", userPosts=" + userPosts +
                ", userComments=" + userComments +
                ", userLikes=" + userLikes +
                ", notifications=" + notifications +
                '}';
    }
}
