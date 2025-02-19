package com.campuslands.Mi_Red_Social.repositories;

import com.campuslands.Mi_Red_Social.entities.UserEntity;
import com.campuslands.Mi_Red_Social.entities.dto.UserUnfollowDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);

    @Query(value = "SELECT u.id, u.name, u.username, u.photo_profile\n" +
            "FROM users u\n" +
            "WHERE u.id NOT IN (\n" +
            "    SELECT f.following_id FROM followers f WHERE f.follower_id = :userId\n" +
            ") \n" +
            "AND u.id <> :userId;",
            nativeQuery = true)
    List<UserUnfollowDTO> noFollow(Integer userId);
}
