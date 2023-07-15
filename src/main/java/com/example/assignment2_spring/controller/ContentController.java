package com.example.assignment2_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/content")
public class ContentController {
    @GetMapping("")
    public String showContent() {
        return "content/form-content";
    }
}
