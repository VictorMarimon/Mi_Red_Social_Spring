package com.campuslands.Mi_Red_Social.services;

import com.campuslands.Mi_Red_Social.entities.TypeNotificationEntity;
import com.campuslands.Mi_Red_Social.repositories.TypeNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeNotificationService {
    @Autowired
    private TypeNotificationRepository typeNotificationRepository;

    public List<TypeNotificationEntity> listTypeNotification(){
        return typeNotificationRepository.findAll();
    }

    public TypeNotificationEntity searchTypeById(Integer id){
        return typeNotificationRepository.findById(id).orElse(null);
    }
}
