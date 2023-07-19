package com.example.assignment2_spring.service;

import com.example.assignment2_spring.entity.ContentEntity;
import com.example.assignment2_spring.entity.MemberEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContentService {
    List<ContentEntity> getAllContent();
    void createContent(ContentEntity content);
    void deleteContent(int id);
    void editContent(ContentEntity content);
    ContentEntity getContentById(int id);
    List<ContentEntity> getByTitle(String title);
    List<ContentEntity> getByKeyword(String keyword, String username);
    List<ContentEntity> getByUsername(String username);
    List<ContentEntity> findByMemberEntity(MemberEntity memberEntity);
    Page<ContentEntity> getContent(Pageable pageable);
    Page<ContentEntity> getContentByMember(MemberEntity member, Pageable pageable);
}
