package com.example.assignment2_spring.repository;

import com.example.assignment2_spring.entity.ContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ContentRepository extends JpaRepository<ContentEntity, Integer> {
}
