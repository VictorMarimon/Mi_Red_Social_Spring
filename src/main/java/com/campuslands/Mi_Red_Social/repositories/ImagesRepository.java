package com.campuslands.Mi_Red_Social.repositories;

import com.campuslands.Mi_Red_Social.entities.ImagesEntity;
import com.campuslands.Mi_Red_Social.entities.dto.ImagesPostDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagesRepository extends JpaRepository<ImagesEntity, Integer> {
    @Query(value = "select id, image from posts_images where posts_id = :id;",
            nativeQuery = true)
    List<ImagesPostDTO> imagesPost(Integer id);
}
