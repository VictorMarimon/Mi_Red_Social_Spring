package com.campuslands.Mi_Red_Social.repositories;

import com.campuslands.Mi_Red_Social.entities.PostsEntity;
import com.campuslands.Mi_Red_Social.entities.dto.PostUser;
import com.campuslands.Mi_Red_Social.entities.dto.PostsDTO;
import com.campuslands.Mi_Red_Social.entities.dto.PostsFollowingUserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<PostsEntity, Integer> {
    @Query(value = "SELECT \n" +
            "    p.id, \n" +
            "    uf.name,\n" +
            "    uf.username,\n" +
            "    uf.photo_profile,\n" +
            "    p.content, \n" +
            "    p.created_at,\n" +
            "    (SELECT COUNT(*) FROM likes lk WHERE lk.posts_id = p.id) AS like_count,\n" +
            "    (SELECT COUNT(*) FROM comments cm WHERE cm.posts_id = p.id) AS comment_count,\n" +
            "    COALESCE(json_agg(DISTINCT pi.image) FILTER (WHERE pi.image IS NOT NULL), '[]') AS images,\n" +
            "    COALESCE(json_agg(DISTINCT pt.tag) FILTER (WHERE pt.tag IS NOT NULL), '[]') AS tags\n" +
            "FROM posts p\n" +
            "LEFT JOIN posts_images pi ON p.id = pi.posts_id\n" +
            "LEFT JOIN posts_tags pt ON p.id = pt.posts_id\n" +
            "INNER JOIN users uf ON p.user_id = uf.id\n" +
            "WHERE p.user_id IN (\n" +
            "    SELECT following_id FROM followers \n" +
            "    WHERE follower_id = (SELECT id FROM users WHERE username = :username)\n" +
            ")\n" +
            "GROUP BY p.id, p.content, p.created_at, uf.name, uf.username, uf.photo_profile;",
            nativeQuery = true)
    List<PostsFollowingUserDTO> postUserFollowing(@Param("username") String username);

    @Query(value = "SELECT \n" +
            "    p.id, \n" +
            "    p.content, \n" +
            "    COALESCE(STRING_AGG(DISTINCT im.image, ','), '') AS images, \n" +
            "    COALESCE(STRING_AGG(DISTINCT pt.tag, ','), '') AS tags, \n" +
            "    p.created_at, \n" +
            "    COUNT(DISTINCT c.id) AS comment_count, \n" +
            "    COUNT(DISTINCT l.id) AS like_count\n" +
            "FROM posts p\n" +
            "LEFT JOIN posts_images im ON p.id = im.posts_id\n" +
            "LEFT JOIN posts_tags pt ON p.id = pt.posts_id\n" +
            "LEFT JOIN likes l ON p.id = l.posts_id\n" +
            "LEFT JOIN comments c ON p.id = c.posts_id\n" +
            "WHERE p.user_id = (SELECT id FROM users WHERE username = :username)\n" +
            "GROUP BY p.id, p.content, p.created_at;",
            nativeQuery = true)
    List<PostUser> postUser(@Param("username") String username);
}
