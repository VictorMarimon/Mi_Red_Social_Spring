package com.campuslands.Mi_Red_Social.controllers;

import com.campuslands.Mi_Red_Social.entities.LikesEntity;
import com.campuslands.Mi_Red_Social.entities.dto.LikeDTO;
import com.campuslands.Mi_Red_Social.exceptions.ResourceNotFoundException;
import com.campuslands.Mi_Red_Social.exceptions.ResourceWithoutContentException;
import com.campuslands.Mi_Red_Social.services.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class LikeController {
    @Autowired
    private LikesService likesService;

    @GetMapping("/like")
    public ResponseEntity<List<LikesEntity>> listLike(){
        return ResponseEntity.ok(likesService.listLike());
    }

    @PostMapping("/like")
    public ResponseEntity<LikesEntity> addLike(@RequestBody LikeDTO likeDTO){
        if (likeDTO == null){
            throw new ResourceWithoutContentException("The like has no content");
        }

        LikesEntity like = likesService.addLike(likeDTO);

        return ResponseEntity.ok(like);
    }

    @DeleteMapping("/like/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteLike(@PathVariable Integer id){
        LikesEntity like = likesService.searchLikeById(id);

        if (like == null){
            throw new ResourceNotFoundException("The received id does not exist: " + id);
        }

        likesService.deleteLike(like);

        Map<String, Boolean> response = new HashMap<>();

        response.put("deleted", true);
        return ResponseEntity.ok(response);
    }
}
