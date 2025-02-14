package com.campuslands.Mi_Red_Social.services;

import com.campuslands.Mi_Red_Social.entities.TypeInteractionEntity;
import com.campuslands.Mi_Red_Social.repositories.TypeInteractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeInteractionService {
    @Autowired
    private TypeInteractionRepository typeInteractionRepository;

    public List<TypeInteractionEntity> listInteraction(){
        return typeInteractionRepository.findAll();
    }

    public TypeInteractionEntity searchTypeById(Integer id){
        return typeInteractionRepository.findById(id).orElse(null);
    }
}
