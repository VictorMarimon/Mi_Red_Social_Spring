package com.campuslands.Mi_Red_Social.controllers;

import com.campuslands.Mi_Red_Social.entities.UserEntity;
import com.campuslands.Mi_Red_Social.exceptions.ResourceNotFoundException;
import com.campuslands.Mi_Red_Social.exceptions.ResourceWithoutContentException;
import com.campuslands.Mi_Red_Social.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity user){
        if (user == null){
            throw new ResourceWithoutContentException("No user information is received");
        }return ResponseEntity.ok(userService.addUser(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> listUsers(){
        return ResponseEntity.ok(userService.listUsers());
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Integer id,
                                                 @RequestBody UserEntity user){
        if (userService.searchUserById(id) == null){
            throw new ResourceNotFoundException("The received id does not exist: " + id);
        }return ResponseEntity.ok(userService.addUser(user));
    }

    @DeleteExchange("/users/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Integer id){
        UserEntity userFound = userService.searchUserById(id);

        if (userFound == null){
            throw new ResourceNotFoundException("The received id does not exist: " + id);
        }
        userService.deleteUser(userFound);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);
        return ResponseEntity.ok(response);
    }
}
