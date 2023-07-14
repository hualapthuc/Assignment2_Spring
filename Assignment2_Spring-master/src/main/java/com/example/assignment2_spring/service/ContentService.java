package com.example.assignment2_spring.service;

import com.example.assignment2_spring.entity.ContentEntity;
import com.example.assignment2_spring.model.Content;

import java.util.List;

public interface ContentService {

    List<ContentEntity> getAllContents();

    void createContent(Content content);

    ContentEntity getContentById(int id);

    void updateContent(int id, Content content);

    void deleteContent(int id);
}
