package com.example.assignment2_spring.service.impl;

import com.example.assignment2_spring.entity.ContentEntity;
import com.example.assignment2_spring.repository.ContentRepository;
import com.example.assignment2_spring.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentRepository contentRepository;

    @Override
    public void addContent(ContentEntity contentEntity) {
        contentRepository.save(contentEntity);
    }

    @Override
    public void deleteContent(int id) {
        contentRepository.deleteById(id);
    }

    @Override
    public void updateContent(ContentEntity contentEntity) {
        contentRepository.save(contentEntity);
    }

    @Override
    public ContentEntity getContentById(int id) {
        return contentRepository.getById(id);
    }
}
