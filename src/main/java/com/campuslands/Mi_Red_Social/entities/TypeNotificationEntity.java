package com.campuslands.Mi_Red_Social.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "type_notification")
public class TypeNotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "type_notification")
    @JsonIgnore
    private List<NotificationEntity> notifications;

    public TypeNotificationEntity(){}

    public TypeNotificationEntity(Integer id, String type, List<NotificationEntity> notifications) {
        this.id = id;
        this.type = type;
        this.notifications = notifications;
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

    public List<NotificationEntity> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<NotificationEntity> notifications) {
        this.notifications = notifications;
    }

    @Override
    public String toString() {
        return "TypeNotificationEntity{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", notifications=" + notifications +
                '}';
    }
}
