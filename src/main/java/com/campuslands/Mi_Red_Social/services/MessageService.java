package com.campuslands.Mi_Red_Social.services;

import com.campuslands.Mi_Red_Social.entities.dto.MessageDTO;
import com.campuslands.Mi_Red_Social.entities.MessageEntity;
import com.campuslands.Mi_Red_Social.entities.UserEntity;
import com.campuslands.Mi_Red_Social.exceptions.ResourceNotFoundException;
import com.campuslands.Mi_Red_Social.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserService userService;

    public MessageEntity addMessage(MessageDTO messageDTO){
        UserEntity userSender = userService.searchUserById(messageDTO.getUser_sender_id());

        UserEntity userReceiver = userService.searchUserById(messageDTO.getUser_receiver_id());

        if (userSender == null){
            throw new ResourceNotFoundException("User not found with id: " + messageDTO.getUser_sender_id());
        } else if (userReceiver == null) {
            throw new ResourceNotFoundException("User not found with id: " + messageDTO.getUser_receiver_id());
        }

        MessageEntity message = new MessageEntity();

        message.setMessage(messageDTO.getMessage());
        message.setChecked(messageDTO.isChecked());
        message.setCreated_at(messageDTO.getCreated_at());
        message.setUser_sender(userSender);
        message.setUser_receiver(userReceiver);

        return messageRepository.save(message);
    }

    public List<MessageEntity> listMessages(){
        return messageRepository.findAll();
    }

    public void deleteMessage(MessageEntity message){
        messageRepository.delete(message);
    }

    public MessageEntity searchMessageById(Integer id){
        return messageRepository.findById(id).orElse(null);
    }
}
