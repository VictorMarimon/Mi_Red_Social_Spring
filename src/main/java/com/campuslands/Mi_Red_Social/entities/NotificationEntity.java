package com.campuslands.Mi_Red_Social.entities;

import jakarta.persistence.*;
import org.yaml.snakeyaml.events.Event;

import java.sql.Timestamp;

@Entity
@Table(name = "notifications")
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "checked")
    private boolean checked;
    @Column(name = "created_at")
    private Timestamp created_at;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user_notifications;

    @ManyToOne
    @JoinColumn(name = "type_notification_id")
    private TypeNotificationEntity type_notification;

    public NotificationEntity(){}

    public NotificationEntity(Integer id, boolean checked, Timestamp created_at, UserEntity user_notifications, TypeNotificationEntity type_notification) {
        this.id = id;
        this.checked = checked;
        this.created_at = created_at;
        this.user_notifications = user_notifications;
        this.type_notification = type_notification;
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

    public UserEntity getUser_notifications() {
        return user_notifications;
    }

    public void setUser_notifications(UserEntity user_notifications) {
        this.user_notifications = user_notifications;
    }

    public TypeNotificationEntity getType_notification() {
        return type_notification;
    }

    public void setType_notification(TypeNotificationEntity type_notification) {
        this.type_notification = type_notification;
    }

    @Override
    public String toString() {
        return "NotificationEntity{" +
                "id=" + id +
                ", checked=" + checked +
                ", created_at=" + created_at +
                ", user_notifications=" + user_notifications +
                ", type_notification=" + type_notification +
                '}';
    }
}
