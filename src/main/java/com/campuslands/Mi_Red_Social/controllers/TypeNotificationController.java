package com.campuslands.Mi_Red_Social.controllers;

import com.campuslands.Mi_Red_Social.entities.TypeNotificationEntity;
import com.campuslands.Mi_Red_Social.services.TypeNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app")
public class TypeNotificationController {
    @Autowired
    private TypeNotificationService typeNotificationService;

    @GetMapping("/type_not")
    public ResponseEntity<List<TypeNotificationEntity>> listTypeNotification(){
        return ResponseEntity.ok(typeNotificationService.listTypeNotification());
    }
}
