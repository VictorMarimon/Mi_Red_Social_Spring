package com.campuslands.Mi_Red_Social.controllers;

import com.campuslands.Mi_Red_Social.entities.TypeInteractionEntity;
import com.campuslands.Mi_Red_Social.services.TypeInteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app")
public class TypeInteractionController {
    @Autowired
    private TypeInteractionService typeInteractionService;

    @GetMapping("/type_int")
    public ResponseEntity<List<TypeInteractionEntity>> listInteraction(){
        return ResponseEntity.ok(typeInteractionService.listInteraction());
    }
}
