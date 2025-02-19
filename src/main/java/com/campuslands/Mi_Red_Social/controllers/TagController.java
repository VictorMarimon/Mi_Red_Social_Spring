package com.campuslands.Mi_Red_Social.controllers;

import com.campuslands.Mi_Red_Social.entities.TagsEntity;
import com.campuslands.Mi_Red_Social.entities.dto.TagDTO;
import com.campuslands.Mi_Red_Social.entities.dto.TagsPostDTO;
import com.campuslands.Mi_Red_Social.exceptions.ResourceNotFoundException;
import com.campuslands.Mi_Red_Social.exceptions.ResourceWithoutContentException;
import com.campuslands.Mi_Red_Social.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/tag")
    public ResponseEntity<List<TagsEntity>> listTags(){
        return ResponseEntity.ok(tagService.listTags());
    }

    @GetMapping("/tag/{id}")
    public ResponseEntity<List<TagsPostDTO>> tagsPost(@PathVariable Integer id){
        return ResponseEntity.ok(tagService.tagsPost(id));
    }

    @PostMapping("/tag")
    public ResponseEntity<List<TagsEntity>> addTags(@RequestBody List<TagDTO> tagDTOs) {
        if (tagDTOs == null || tagDTOs.isEmpty()) {
            throw new ResourceWithoutContentException("The tags list has no content");
        }

        List<TagsEntity> savedTags = tagService.addTags(tagDTOs);
        return ResponseEntity.ok(savedTags);
    }


    @DeleteMapping("/tag/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteTag(@PathVariable Integer id){
        TagsEntity tag = tagService.searchTagById(id);

        if (tag == null){
            throw new ResourceNotFoundException("The received id does not exist: " + id);
        }

        tagService.deleteTag(tag);

        Map<String, Boolean> response = new HashMap<>();

        response.put("deleted", true);
        return ResponseEntity.ok(response);
    }
}
