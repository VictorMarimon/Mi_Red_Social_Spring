package com.campuslands.Mi_Red_Social.services;

import com.campuslands.Mi_Red_Social.entities.UserEntity;
import com.campuslands.Mi_Red_Social.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity addUser(UserEntity newUser){
        return userRepository.save(newUser);
    }

    public List<UserEntity> listUsers(){
        return userRepository.findAll();
    }

    public void deleteUser(UserEntity deletedUser){
        userRepository.delete(deletedUser);
    }

    public UserEntity searchUserById(Integer idUser){
        return userRepository.findById(idUser).orElse(null);
    }
}
