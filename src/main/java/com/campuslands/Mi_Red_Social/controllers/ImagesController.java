package com.campuslands.Mi_Red_Social.controllers;

import com.campuslands.Mi_Red_Social.entities.ImagesEntity;
import com.campuslands.Mi_Red_Social.entities.TagsEntity;
import com.campuslands.Mi_Red_Social.entities.dto.ImageDTO;
import com.campuslands.Mi_Red_Social.entities.dto.ImagesPostDTO;
import com.campuslands.Mi_Red_Social.entities.dto.TagDTO;
import com.campuslands.Mi_Red_Social.exceptions.ResourceNotFoundException;
import com.campuslands.Mi_Red_Social.exceptions.ResourceWithoutContentException;
import com.campuslands.Mi_Red_Social.services.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class ImagesController {
    @Autowired
    private ImagesService imagesService;

    @GetMapping("/image")
    public ResponseEntity<List<ImagesEntity>> listImages(){
        return ResponseEntity.ok(imagesService.listImages());
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<List<ImagesPostDTO>> imagesPost(@PathVariable Integer id){
        return ResponseEntity.ok(imagesService.imagesPost(id));
    }

    @PostMapping("/image")
    public ResponseEntity<List<ImagesEntity>> addImages(@RequestBody List<ImageDTO> imageDTOs) {
        if (imageDTOs == null || imageDTOs.isEmpty()) {
            throw new ResourceWithoutContentException("No images provided");
        }

        List<ImagesEntity> savedImages = imagesService.addImages(imageDTOs);

        return ResponseEntity.ok(savedImages);
    }

    @DeleteMapping("/image/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteImage(@PathVariable Integer id){
        ImagesEntity image = imagesService.searchImageById(id);

        if (image == null){
            throw new ResourceNotFoundException("The received id does not exist: " + id);
        }

        imagesService.deleteImage(image);

        Map<String, Boolean> response = new HashMap<>();

        response.put("deleted", true);
        return ResponseEntity.ok(response);
    }
}
