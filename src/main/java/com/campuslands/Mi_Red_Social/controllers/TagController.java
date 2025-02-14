package com.campuslands.Mi_Red_Social.controllers;

import com.campuslands.Mi_Red_Social.entities.TagsEntity;
import com.campuslands.Mi_Red_Social.entities.dto.TagDTO;
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

    @PostMapping("/tag")
    public ResponseEntity<TagsEntity> addImage(@RequestBody TagDTO tagDTO){
        if (tagDTO == null){
            throw new ResourceWithoutContentException("The tag has no content");
        }

        TagsEntity tag = tagService.addTag(tagDTO);

        return ResponseEntity.ok(tag);
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
