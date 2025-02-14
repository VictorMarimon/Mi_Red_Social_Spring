package com.campuslands.Mi_Red_Social.controllers;

import com.campuslands.Mi_Red_Social.entities.CommentsEntity;
import com.campuslands.Mi_Red_Social.entities.dto.CommentDTO;
import com.campuslands.Mi_Red_Social.exceptions.ResourceNotFoundException;
import com.campuslands.Mi_Red_Social.exceptions.ResourceWithoutContentException;
import com.campuslands.Mi_Red_Social.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;

    @GetMapping("/comment")
    public ResponseEntity<List<CommentsEntity>> listComments(){
        return ResponseEntity.ok(commentsService.listComments());
    }

    @PostMapping("/comment")
    public ResponseEntity<CommentsEntity> addComment(@RequestBody CommentDTO commentDTO){
        if (commentDTO == null){
            throw new ResourceWithoutContentException("The comment has no content");
        }

        CommentsEntity comment = commentsService.addComment(commentDTO);

        return ResponseEntity.ok(comment);
    }

    @DeleteMapping("/comment/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteComment(@PathVariable Integer id){
        CommentsEntity comment = commentsService.searchCommentById(id);

        if (comment == null){
            throw new ResourceNotFoundException("The received id does not exist: " + id);
        }

        commentsService.deleteComment(comment);

        Map<String, Boolean> response = new HashMap<>();

        response.put("deleted", true);
        return ResponseEntity.ok(response);
    }
}
