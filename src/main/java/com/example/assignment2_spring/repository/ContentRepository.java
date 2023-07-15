package com.example.assignment2_spring.repository;

import com.example.assignment2_spring.entity.ContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  ContentRepository extends JpaRepository<ContentEntity, Integer> {
    List<ContentEntity> findByTitle(String title);
}
