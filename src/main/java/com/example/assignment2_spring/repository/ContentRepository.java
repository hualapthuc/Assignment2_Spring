package com.example.assignment2_spring.repository;

import com.example.assignment2_spring.entity.ContentEntity;
import com.example.assignment2_spring.entity.MemberEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<ContentEntity, Integer> {
    List<ContentEntity> findByTitle(String title);
    @Query("SELECT c FROM ContentEntity c WHERE c.title LIKE %:keyword% AND c.memberEntity.userName LIKE %:username%")
    List<ContentEntity> findByKeyword(String keyword, String username);
    @Query("SELECT c FROM ContentEntity c WHERE c.memberEntity.userName LIKE %:username%")
    List<ContentEntity> findByMemberUsername(String username);

    List<ContentEntity> findContentEntitiesByMemberEntity(MemberEntity memberEntity);

    Page<ContentEntity> findAll(Pageable pageable);
    Page<ContentEntity> findByMemberEntity(MemberEntity member, Pageable pageable);
}

