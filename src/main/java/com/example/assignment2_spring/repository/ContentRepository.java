package com.example.assignment2_spring.repository;

import com.example.assignment2_spring.entity.ContentEntity;
import com.example.assignment2_spring.entity.MemberEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface  ContentRepository extends JpaRepository<ContentEntity, Integer> {
    @Query("SELECT c FROM ContentEntity c WHERE c.title LIKE %:keyword% or c.brief like %:keyword%")
    List<ContentEntity> findByKeyword(String keyword);

    Page<ContentEntity> findByMemberEntity(MemberEntity memberEntity, Pageable pageable);

    @Query("SELECT c FROM ContentEntity c WHERE c.memberEntity.id = :memberId")
    Page<ContentEntity> findByMemberId(@Param("memberId") int memberId, Pageable pageable);

    List<ContentEntity> findByMemberEntity(MemberEntity memberEntity);
}
