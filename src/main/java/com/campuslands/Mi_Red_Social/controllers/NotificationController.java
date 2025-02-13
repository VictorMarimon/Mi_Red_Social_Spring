package com.campuslands.Mi_Red_Social.controllers;

import com.campuslands.Mi_Red_Social.dto.NotificationDTO;
import com.campuslands.Mi_Red_Social.entities.NotificationEntity;
import com.campuslands.Mi_Red_Social.exceptions.ResourceNotFoundException;
import com.campuslands.Mi_Red_Social.exceptions.ResourceWithoutContentException;
import com.campuslands.Mi_Red_Social.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notification")
    public ResponseEntity<List<NotificationEntity>> listNotification(){
        return ResponseEntity.ok(notificationService.listNotification());
    }

    @PostMapping("/notification")
    public ResponseEntity<NotificationEntity> addNotification(@RequestBody NotificationDTO notificationDTO){
        if (notificationDTO == null){
            throw new ResourceWithoutContentException("The notification has no content");
        }

        NotificationEntity notification = notificationService.addNotification(notificationDTO);

        return ResponseEntity.ok(notification);
    }

    @DeleteMapping("/notification/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteNotification(@PathVariable Integer id){

        NotificationEntity notificationFound = notificationService.searchNotificationById(id);

        if (notificationFound == null){
            throw new ResourceNotFoundException("The received id does not exist: " + id);
        }
        notificationService.deleteNotification(notificationFound);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);
        return ResponseEntity.ok(response);

    }
}
