package com.example.assignment2_spring.controller;

import com.example.assignment2_spring.entity.ContentEntity;
import com.example.assignment2_spring.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.AbstractDocument;

@Controller
@RequestMapping("/content")
public class ContentController {
    @Autowired
    private ContentService contentService;
    @GetMapping("")
    public  String contentList(Model model) {
        model.addAttribute("listContent",contentService.getAllContent());
        return "content/view-content";
    }
    @GetMapping("/create-content")
    public String createContent(Model model) {
        model.addAttribute("contents",new ContentEntity());
        return "content/form-content";
    }
    @PostMapping("/save-content")
    public  String savePContent(@ModelAttribute ContentEntity content, BindingResult bindingResult, Model model) {
        contentService.createContent(content);
        return "redirect:/content";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        ContentEntity content = contentService.getContentById(id);
        model.addAttribute("contents", content);
        return "content/edit-content";
    }
    @PostMapping ("/update-content")
    public String updateContent(@ModelAttribute("content") ContentEntity content, BindingResult result, Model model) {
        contentService.createContent(content);
        return "redirect:/content/";
    }
    @GetMapping("/delete/{id}")
    public String deleteContent(@PathVariable int id) {
        contentService.deleteContent(id);
        return "redirect:/content/";
    }
    @PostMapping("/search")
    public String search(@RequestParam("search") String search, Model model) {
        model.addAttribute("titleContent", contentService.getByTitle(search));
        return "content/view-content";
    }
}