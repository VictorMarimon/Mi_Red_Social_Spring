package com.campuslands.Mi_Red_Social.controllers;

import com.campuslands.Mi_Red_Social.entities.dto.PostsDTO;
import com.campuslands.Mi_Red_Social.entities.PostsEntity;
import com.campuslands.Mi_Red_Social.exceptions.ResourceNotFoundException;
import com.campuslands.Mi_Red_Social.exceptions.ResourceWithoutContentException;
import com.campuslands.Mi_Red_Social.services.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class PostsController {
    @Autowired
    private PostsService postsService;

    @GetMapping("/posts")
    public ResponseEntity<List<PostsEntity>> listPosts(){
        return ResponseEntity.ok(postsService.listPosts());
    }

    @PostMapping("/posts")
    public ResponseEntity<PostsEntity> addPosts(@RequestBody PostsDTO postsDTO){
        if (postsDTO == null){
            throw new ResourceWithoutContentException("The post has no content");
        }

        PostsEntity posts = postsService.addPost(postsDTO);
        return ResponseEntity.ok(posts);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePosts(@PathVariable Integer id){
        PostsEntity posts = postsService.searchPostById(id);
        if (posts == null){
            throw new ResourceNotFoundException("The received id does not exist: " + id);
        }
        postsService.deletePost(posts);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);
        return ResponseEntity.ok(response);
    }
}
