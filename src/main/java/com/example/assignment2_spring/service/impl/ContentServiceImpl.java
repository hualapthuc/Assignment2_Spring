package com.example.assignment2_spring.service.impl;

import com.example.assignment2_spring.entity.ContentEntity;
import com.example.assignment2_spring.entity.MemberEntity;
import com.example.assignment2_spring.repository.ContentRepository;
import com.example.assignment2_spring.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentRepository contentRepository;

    @Override
    public List<ContentEntity> getAllContent() {
        return contentRepository.findAll();
    }

    @Override
    public void createContent(ContentEntity content) {
        contentRepository.save(content);
    }

    @Override
    public void deleteContent(int id) {
        contentRepository.deleteById(id);
    }

    @Override
    public void editContent(ContentEntity content) {
        contentRepository.save(content);
    }

    @Override
    public ContentEntity getContentById(int id) {
        return contentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("content not found"));
    }

    @Override
    public List<ContentEntity> getByTitle(String title) {
        return contentRepository.findByTitle(title);
    }
    @Override
    public List<ContentEntity> getByKeyword(String keyword, String username) {
        return contentRepository.findByKeyword(keyword, username);
    }

    @Override
    public List<ContentEntity> getByUsername(String username) {
        return contentRepository.findByMemberUsername(username);
    }
    @Override
    public List<ContentEntity> findByMemberEntity(MemberEntity memberEntity) {
        return contentRepository.findContentEntitiesByMemberEntity(memberEntity);
    }

    @Override
    public Page<ContentEntity> getContent(Pageable pageable) {
        return contentRepository.findAll(pageable);
    }

    @Override
    public Page<ContentEntity> getContentByMember(MemberEntity member, Pageable pageable) {
        return contentRepository.findByMemberEntity(member,pageable);
    }
}
