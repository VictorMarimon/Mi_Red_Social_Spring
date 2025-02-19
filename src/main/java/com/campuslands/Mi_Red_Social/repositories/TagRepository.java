package com.campuslands.Mi_Red_Social.repositories;

import com.campuslands.Mi_Red_Social.entities.TagsEntity;
import com.campuslands.Mi_Red_Social.entities.dto.ImagesPostDTO;
import com.campuslands.Mi_Red_Social.entities.dto.TagsPostDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<TagsEntity, Integer> {
    @Query(value = "select id, tag from posts_tags where posts_id = :id;",
            nativeQuery = true)
    List<TagsPostDTO> tagsPost(Integer id);
}
