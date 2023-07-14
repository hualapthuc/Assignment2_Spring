package com.example.assignment2_spring.service.impl;

import com.example.assignment2_spring.entity.ContentEntity;
import com.example.assignment2_spring.model.Content;
import com.example.assignment2_spring.repository.ContentRepository;
import com.example.assignment2_spring.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    private final ContentRepository contentRepository;

    @Autowired
    public ContentServiceImpl(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Override
    public List<ContentEntity> getAllContents() {
        return contentRepository.findAll();
    }

    @Override
    public void createContent(Content content) {
        ContentEntity contentEntity = new ContentEntity();
        // Set contentEntity properties from content object
        contentRepository.save(contentEntity);
    }

    @Override
    public ContentEntity getContentById(int id) {
        return contentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid content ID: " + id));
    }

    @Override
    public void updateContent(int id, Content content) {
        ContentEntity contentEntity = getContentById(id);
        // Update contentEntity properties from content object
        contentRepository.save(contentEntity);
    }

    @Override
    public void deleteContent(int id) {
        contentRepository.deleteById(id);
    }
}
