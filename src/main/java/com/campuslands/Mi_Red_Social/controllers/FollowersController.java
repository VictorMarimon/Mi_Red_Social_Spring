package com.campuslands.Mi_Red_Social.controllers;

import com.campuslands.Mi_Red_Social.dto.FollowerDTO;
import com.campuslands.Mi_Red_Social.entities.FollowersEntity;
import com.campuslands.Mi_Red_Social.exceptions.ResourceNotFoundException;
import com.campuslands.Mi_Red_Social.exceptions.ResourceWithoutContentException;
import com.campuslands.Mi_Red_Social.services.FollowersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class FollowersController {
    @Autowired
    private FollowersService followersService;

    @GetMapping("/follow")
    public ResponseEntity<List<FollowersEntity>> listFollows(){
        return ResponseEntity.ok(followersService.listFollowers());
    }

    @PostMapping("/follow")
    public ResponseEntity<FollowersEntity> addFollow(@RequestBody FollowerDTO followerDTO){
        if (followerDTO == null){
            throw new ResourceWithoutContentException("The follow has no content");
        }

        FollowersEntity follow = followersService.addFollow(followerDTO);
        return ResponseEntity.ok(follow);
    }

    @DeleteMapping("/follow/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteFollow(@PathVariable Integer id){
        FollowersEntity followFound = followersService.findFollowById(id);

        if (followFound == null){
            throw new ResourceNotFoundException("The received id does not exist: " + id);
        }

        followersService.deleteFollow(followFound);

        Map<String, Boolean> response = new HashMap<>();

        response.put("deleted", true);
        return ResponseEntity.ok(response);
    }
}
