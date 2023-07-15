package com.example.assignment2_spring.repository;

import com.example.assignment2_spring.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
    @Query("SELECT m FROM MemberEntity m WHERE m.userName = ?1 AND m.password = ?2")
    MemberEntity findMemberEntitiesByUserNameAndPassword(String userName, String password);
}
