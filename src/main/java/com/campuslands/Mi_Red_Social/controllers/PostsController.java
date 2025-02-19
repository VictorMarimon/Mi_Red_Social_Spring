package com.campuslands.Mi_Red_Social.controllers;

import com.campuslands.Mi_Red_Social.entities.UserEntity;
import com.campuslands.Mi_Red_Social.entities.dto.PostUser;
import com.campuslands.Mi_Red_Social.entities.dto.PostsDTO;
import com.campuslands.Mi_Red_Social.entities.PostsEntity;
import com.campuslands.Mi_Red_Social.entities.dto.PostsFollowingUserDTO;
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

    @GetMapping("/posts/{username}")
    public ResponseEntity<List<PostsFollowingUserDTO>> listPostUserFollowing(@PathVariable String username){
        return ResponseEntity.ok(postsService.userPostFollowing(username));
    }

    @GetMapping("/posts/user/{username}")
    public ResponseEntity<List<PostUser>> postsUser(@PathVariable String username){
        return ResponseEntity.ok(postsService.postsUser(username));
    }

    @PostMapping("/posts")
    public ResponseEntity<PostsEntity> addPosts(@RequestBody PostsDTO postsDTO){
        if (postsDTO == null){
            throw new ResourceWithoutContentException("The post has no content");
        }
        PostsEntity posts = postsService.addPost(postsDTO);
        return ResponseEntity.ok(posts);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<PostsEntity> updateUser(@PathVariable Integer id,
                                                 @RequestBody PostsDTO post){
        if (postsService.searchPostById(id) == null){
            throw new ResourceNotFoundException("The received id does not exist: " + id);
        }return ResponseEntity.ok(postsService.updatePost(post));
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
