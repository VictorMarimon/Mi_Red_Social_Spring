package com.campuslands.Mi_Red_Social.repositories;

import com.campuslands.Mi_Red_Social.entities.LikesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<LikesEntity, Integer> {
}
