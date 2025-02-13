package com.campuslands.Mi_Red_Social.dto;

import java.sql.Timestamp;

public class MessageDTO {
    private Integer id;
    private String message;
    private boolean checked;
    private Timestamp created_at;
    private Integer user_sender_id;
    private Integer user_receiver_id;

    public MessageDTO(){}

    public MessageDTO(Integer id, String message, boolean checked, Timestamp created_at, Integer user_sender_id, Integer user_receiver_id) {
        this.id = id;
        this.message = message;
        this.checked = checked;
        this.created_at = created_at;
        this.user_sender_id = user_sender_id;
        this.user_receiver_id = user_receiver_id;
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

    public Integer getUser_sender_id() {
        return user_sender_id;
    }

    public void setUser_sender_id(Integer user_sender_id) {
        this.user_sender_id = user_sender_id;
    }

    public Integer getUser_receiver_id() {
        return user_receiver_id;
    }

    public void setUser_receiver_id(Integer user_receiver_id) {
        this.user_receiver_id = user_receiver_id;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", checked=" + checked +
                ", created_at=" + created_at +
                ", user_sender_id=" + user_sender_id +
                ", user_receiver_id=" + user_receiver_id +
                '}';
    }
}
