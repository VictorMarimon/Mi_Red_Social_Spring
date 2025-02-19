package com.campuslands.Mi_Red_Social.repositories;

import com.campuslands.Mi_Red_Social.entities.CommentsEntity;
import com.campuslands.Mi_Red_Social.entities.dto.CommentPostDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<CommentsEntity, Integer> {
    @Query(value = "select c.id, c.comment, c.created_at, u.username, u.photo_profile\n" +
            "from comments c\n" +
            "inner join users u on u.id = c.user_id\n" +
            "where c.posts_id = :id_post;",
            nativeQuery = true)
    List<CommentPostDTO> commentPost(@Param("id_post") Integer id_post);
}
