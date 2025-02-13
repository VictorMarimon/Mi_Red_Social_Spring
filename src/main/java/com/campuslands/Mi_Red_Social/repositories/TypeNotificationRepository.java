package com.campuslands.Mi_Red_Social.repositories;

import com.campuslands.Mi_Red_Social.entities.TypeNotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeNotificationRepository extends JpaRepository<TypeNotificationEntity, Integer> {
}
