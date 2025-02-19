package com.campuslands.Mi_Red_Social.services;

import com.campuslands.Mi_Red_Social.entities.ImagesEntity;
import com.campuslands.Mi_Red_Social.entities.PostsEntity;
import com.campuslands.Mi_Red_Social.entities.dto.ImageDTO;
import com.campuslands.Mi_Red_Social.entities.dto.ImagesPostDTO;
import com.campuslands.Mi_Red_Social.exceptions.ResourceNotFoundException;
import com.campuslands.Mi_Red_Social.repositories.ImagesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ImagesService {
    @Autowired
    private ImagesRepository imagesRepository;
    @Autowired
    private PostsService postsService;

    public List<ImagesEntity> listImages(){
        return imagesRepository.findAll();
    }

    public List<ImagesEntity> addImages(List<ImageDTO> imageDTOs) {
        if (imageDTOs == null || imageDTOs.isEmpty()) {
            throw new IllegalArgumentException("No images provided.");
        }

        PostsEntity postImage = postsService.searchPostById(imageDTOs.get(0).getPost_image_id());

        if (postImage == null) {
            throw new ResourceNotFoundException("Post not found with id: " + imageDTOs.get(0).getPost_image_id());
        }

        List<ImagesEntity> images = imageDTOs.stream().map(dto -> {
            ImagesEntity image = new ImagesEntity();
            image.setId(dto.getId());
            image.setImage(dto.getImage());
            image.setPost_images(postImage);
            return image;
        }).collect(Collectors.toList());

        return imagesRepository.saveAll(images);
    }

    public List<ImagesPostDTO> imagesPost(Integer id){
        return imagesRepository.imagesPost(id);
    }

    public void deleteImage(ImagesEntity image){
        imagesRepository.delete(image);
    }

    public ImagesEntity searchImageById(Integer id){
        return imagesRepository.findById(id).orElse(null);
    }
}
