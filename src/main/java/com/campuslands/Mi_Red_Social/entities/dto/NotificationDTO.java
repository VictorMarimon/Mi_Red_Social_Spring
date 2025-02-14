package com.campuslands.Mi_Red_Social.entities.dto;

import java.sql.Timestamp;

public class NotificationDTO {
    private Integer id;
    private boolean checked;
    private Timestamp created_at;
    private Integer user_notification_id;
    private Integer type_notification_id;

    public NotificationDTO(){}

    public NotificationDTO(Integer id, boolean checked, Timestamp created_at, Integer user_notification_id, Integer type_notification_id) {
        this.id = id;
        this.checked = checked;
        this.created_at = created_at;
        this.user_notification_id = user_notification_id;
        this.type_notification_id = type_notification_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getUser_notification_id() {
        return user_notification_id;
    }

    public void setUser_notification_id(Integer user_notification_id) {
        this.user_notification_id = user_notification_id;
    }

    public Integer getType_notification_id() {
        return type_notification_id;
    }

    public void setType_notification_id(Integer type_notification_id) {
        this.type_notification_id = type_notification_id;
    }

    @Override
    public String toString() {
        return "NotificationDTO{" +
                "id=" + id +
                ", checked=" + checked +
                ", created_at=" + created_at +
                ", user_notification_id=" + user_notification_id +
                ", type_notification_id=" + type_notification_id +
                '}';
    }
}
