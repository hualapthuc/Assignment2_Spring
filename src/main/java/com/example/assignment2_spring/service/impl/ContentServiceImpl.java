package com.example.assignment2_spring.service.impl;

import com.example.assignment2_spring.entity.ContentEntity;
import com.example.assignment2_spring.repository.ContentRepository;
import com.example.assignment2_spring.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
