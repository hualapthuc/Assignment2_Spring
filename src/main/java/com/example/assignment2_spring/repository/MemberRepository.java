package com.example.assignment2_spring.repository;

import com.example.assignment2_spring.entity.ContentEntity;
import com.example.assignment2_spring.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
    @Query("SELECT m FROM MemberEntity m WHERE m.userName = ?1 AND m.password = ?2")
    MemberEntity findMemberEntityByUserNameAndPassword(String username, String password);

    @Query("UPDATE MemberEntity m SET m.password = ?1 WHERE m.id = ?2")
    MemberEntity updateMemberEntityByPasswordAfter(String password, int id);

    MemberEntity findMemberEntityByUserName(String username);
    MemberEntity findMemberEntityByEmail(String email);
}
