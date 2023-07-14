package com.example.assignment2_spring.repository;

import com.example.assignment2_spring.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<MemberEntity, Integer> {
    MemberEntity findByUserName(String username);
}

