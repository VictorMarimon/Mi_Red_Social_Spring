package com.campuslands.Mi_Red_Social.entities;

import jakarta.persistence.*;

import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "messages")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "message")
    private String message;
    @Column(name = "checked")
    private boolean checked;
    @Column(name = "created_at")
    private Timestamp created_at;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserEntity user_sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private UserEntity user_receiver;

    public MessageEntity(){}

    public MessageEntity(Integer id, String message, boolean checked, Timestamp created_at, UserEntity user_sender, UserEntity user_receiver) {
        this.id = id;
        this.message = message;
        this.checked = checked;
        this.created_at = created_at;
        this.user_sender = user_sender;
        this.user_receiver = user_receiver;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public UserEntity getUser_sender() {
        return user_sender;
    }

    public void setUser_sender(UserEntity user_sender) {
        this.user_sender = user_sender;
    }

    public UserEntity getUser_receiver() {
        return user_receiver;
    }

    public void setUser_receiver(UserEntity user_receiver) {
        this.user_receiver = user_receiver;
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", checked=" + checked +
                ", created_at=" + created_at +
                ", user_sender=" + user_sender +
                ", user_receiver=" + user_receiver +
                '}';
    }
}
