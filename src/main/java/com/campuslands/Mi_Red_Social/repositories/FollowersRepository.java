package com.campuslands.Mi_Red_Social.repositories;

import com.campuslands.Mi_Red_Social.entities.FollowersEntity;
import com.campuslands.Mi_Red_Social.entities.dto.FollowerDTO;
import com.campuslands.Mi_Red_Social.entities.dto.FollowersUserDTO;
import com.campuslands.Mi_Red_Social.entities.dto.FollowsDTO;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FollowersRepository extends JpaRepository<FollowersEntity, Integer> {
    @Query(value = "SELECT \n" +
            "    (SELECT COUNT(*) FROM followers WHERE following_id = :id_user) AS followers_count,\n" +
            "    (SELECT COUNT(*) FROM followers WHERE follower_id = :id_user) AS following_count;",
            nativeQuery = true)
    FollowersUserDTO followers(Integer id_user);

    @Query(value = "SELECT u.id, u.name, u.username, u.photo_profile\n" +
            "FROM users u\n" +
            "JOIN followers f ON u.id = f.follower_id\n" +
            "WHERE f.following_id = :id_user;",
            nativeQuery = true)
    List<FollowsDTO> userFollowers(Integer id_user);

    @Query(value = "SELECT u.id, u.name, u.username, u.photo_profile\n" +
            "FROM users u\n" +
            "JOIN followers f ON u.id = f.following_id\n" +
            "WHERE f.follower_id = :id_user;",
            nativeQuery = true)
    List<FollowsDTO> userFollowing(Integer id_user);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM followers\n" +
            "WHERE follower_id = :id_follower AND following_id = :id_following;",
            nativeQuery = true)
    void deleteFollow(Integer id_follower, Integer id_following);
}
