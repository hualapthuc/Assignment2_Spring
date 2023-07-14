package com.example.assignment2_spring.service.impl;

import com.example.assignment2_spring.repository.ContentRepository;
import com.example.assignment2_spring.service.ContentService;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl implements ContentService {
    private ContentRepository contentRepository;
}
