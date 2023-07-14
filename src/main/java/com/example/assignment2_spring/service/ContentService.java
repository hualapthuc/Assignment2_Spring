package com.example.assignment2_spring.service;

import com.example.assignment2_spring.entity.ContentEntity;
import com.example.assignment2_spring.entity.MemberEntity;

public interface ContentService {
    public void addContent(ContentEntity contentEntity);
    public void deleteContent(int id);
    public void updateContent(ContentEntity contentEntity);
    public ContentEntity getContentById(int id);
}
