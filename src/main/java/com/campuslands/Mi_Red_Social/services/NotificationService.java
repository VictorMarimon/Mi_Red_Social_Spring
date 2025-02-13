package com.campuslands.Mi_Red_Social.services;

import com.campuslands.Mi_Red_Social.dto.NotificationDTO;
import com.campuslands.Mi_Red_Social.entities.NotificationEntity;
import com.campuslands.Mi_Red_Social.entities.TypeNotificationEntity;
import com.campuslands.Mi_Red_Social.entities.UserEntity;
import com.campuslands.Mi_Red_Social.exceptions.ResourceNotFoundException;
import com.campuslands.Mi_Red_Social.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private TypeNotificationService typeNotificationService;

    public List<NotificationEntity> listNotification(){
        return notificationRepository.findAll();
    }

    public NotificationEntity addNotification(NotificationDTO notificationDTO){
        UserEntity userNotification = userService.searchUserById(notificationDTO.getUser_notification_id());

        TypeNotificationEntity typeNotification = typeNotificationService.searchTypeById(notificationDTO.getType_notification_id());

        if (userNotification == null){
            throw new ResourceNotFoundException("User not found with id: " + notificationDTO.getUser_notification_id());
        } else if (typeNotification == null) {
            throw new ResourceNotFoundException("Type not found with id: " + notificationDTO.getType_notification_id());
        }

        NotificationEntity notification = new NotificationEntity();

        notification.setId(notificationDTO.getId());
        notification.setChecked(notificationDTO.isChecked());
        notification.setCreated_at(notificationDTO.getCreated_at());
        notification.setType_notification(typeNotification);
        notification.setUser_notifications(userNotification);

        return notificationRepository.save(notification);
    }

    public NotificationEntity searchNotificationById(Integer id){
        return notificationRepository.findById(id).orElse(null);
    }

    public void deleteNotification(NotificationEntity notification){
        notificationRepository.delete(notification);
    }
}
