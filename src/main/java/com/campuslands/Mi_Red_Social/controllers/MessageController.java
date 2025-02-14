package com.campuslands.Mi_Red_Social.controllers;

import com.campuslands.Mi_Red_Social.entities.dto.MessageDTO;
import com.campuslands.Mi_Red_Social.entities.MessageEntity;
import com.campuslands.Mi_Red_Social.exceptions.ResourceNotFoundException;
import com.campuslands.Mi_Red_Social.exceptions.ResourceWithoutContentException;
import com.campuslands.Mi_Red_Social.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/messages")
    public ResponseEntity<MessageEntity> addMessage(@RequestBody MessageDTO messageDTO){
        if (messageDTO == null){
            throw new ResourceWithoutContentException("The message has no content");
        }
        MessageEntity message = messageService.addMessage(messageDTO);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/messages")
    public ResponseEntity<List<MessageEntity>> listMessage(){
        return ResponseEntity.ok(messageService.listMessages());
    }

    @DeleteMapping("/messages/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Integer id){
        MessageEntity messageFound = messageService.searchMessageById(id);

        if (messageFound == null){
            throw new ResourceNotFoundException("The received id does not exist: " + id);
        }
        messageService.deleteMessage(messageFound);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);
        return ResponseEntity.ok(response);
    }
}
