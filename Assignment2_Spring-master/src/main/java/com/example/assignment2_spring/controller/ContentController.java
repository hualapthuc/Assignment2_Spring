package com.example.assignment2_spring.controller;

import com.example.assignment2_spring.entity.ContentEntity;
import com.example.assignment2_spring.model.Content;
import com.example.assignment2_spring.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/content")
public class ContentController {

    private final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    // Mapping for list page
    @GetMapping("/list")
    public String getAllContents(Model model) {
        List<ContentEntity> contents = contentService.getAllContents();
        model.addAttribute("contents", contents);
        return "content/list";
    }

    // Mapping for create page
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("content", new Content());
        return "content/create";
    }

    // Mapping for handling create form submission
    @PostMapping("/create")
    public String createContent(@Valid @ModelAttribute("content") Content content, BindingResult result) {
        if (result.hasErrors()) {
            return "content/create";
        }

        contentService.createContent(content);
        return "redirect:/content/list";
    }

    // Mapping for edit page
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        ContentEntity content = contentService.getContentById(id);
        model.addAttribute("content", content);
        return "content/edit";
    }

    // Mapping for handling edit form submission
    @PostMapping("/edit/{id}")
    public String updateContent(@PathVariable("id") int id, @Valid @ModelAttribute("content") Content content,
                                BindingResult result) {
        if (result.hasErrors()) {
            return "content/edit";
        }

        contentService.updateContent(id, content);
        return "redirect:/content/list";
    }

    // Mapping for view page
    @GetMapping("/view/{id}")
    public String showContentDetails(@PathVariable("id") int id, Model model) {
        ContentEntity content = contentService.getContentById(id);
        model.addAttribute("content", content);
        return "content/view";
    }

    // Mapping for delete
    @GetMapping("/delete/{id}")
    public String deleteContent(@PathVariable("id") int id) {
        contentService.deleteContent(id);
        return "redirect:/content/list";
    }
}
