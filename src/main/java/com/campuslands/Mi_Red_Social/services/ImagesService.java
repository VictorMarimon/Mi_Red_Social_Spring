package com.campuslands.Mi_Red_Social.services;

import com.campuslands.Mi_Red_Social.entities.ImagesEntity;
import com.campuslands.Mi_Red_Social.entities.PostsEntity;
import com.campuslands.Mi_Red_Social.entities.dto.ImageDTO;
import com.campuslands.Mi_Red_Social.exceptions.ResourceNotFoundException;
import com.campuslands.Mi_Red_Social.repositories.ImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagesService {
    @Autowired
    private ImagesRepository imagesRepository;
    @Autowired
    private PostsService postsService;

    public List<ImagesEntity> listImages(){
        return imagesRepository.findAll();
    }

    public ImagesEntity addImage(ImageDTO imageDTO){
        PostsEntity postImage = postsService.searchPostById(imageDTO.getPost_image_id());

        if (postImage == null){
            throw new ResourceNotFoundException("Post not found with id: " + imageDTO.getPost_image_id());
        }

        ImagesEntity image = new ImagesEntity();

        image.setId(imageDTO.getPost_image_id());
        image.setImage(imageDTO.getImage());
        image.setPost_images(postImage);

        return imagesRepository.save(image);
    }

    public void deleteImage(ImagesEntity image){
        imagesRepository.delete(image);
    }

    public ImagesEntity searchImageById(Integer id){
        return imagesRepository.findById(id).orElse(null);
    }
}
