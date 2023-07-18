package com.example.assignment2_spring.service;

import com.example.assignment2_spring.entity.ContentEntity;
import com.example.assignment2_spring.entity.MemberEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.swing.text.AbstractDocument;
import java.util.List;
import java.util.Optional;

public interface ContentService {
     List<ContentEntity> getAllContent();
     void createContent(ContentEntity content);
     void deleteContent(Integer id);
     void editContent(ContentEntity content);
     ContentEntity getContentById(int id);
     List<ContentEntity> getByKeyword(String keyword);

     Page<ContentEntity> getAllContents(Pageable pageable);
     Page<ContentEntity> findByMemberEntity(MemberEntity memberEntity, Pageable pageable);

     Page<ContentEntity> getPaginatedContents(int page, int size);

     List<ContentEntity> getMemberContentPaged(int memberId, int page, int pageSize);
     public int getTotalPagesForMemberContent(int memberId, int pageSize);
     List<ContentEntity> findByMemberEntity(MemberEntity memberEntity);


}
