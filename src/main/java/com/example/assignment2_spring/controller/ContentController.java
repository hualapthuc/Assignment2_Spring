package com.example.assignment2_spring.controller;

import com.example.assignment2_spring.entity.ContentEntity;
import com.example.assignment2_spring.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

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
        contentService.editContent(content);
        return "redirect:/content";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        ContentEntity content = contentService.getContentById(id);
        model.addAttribute("contents", content);
        return "content/edit-content";
    }
    @PostMapping ("/update-content")
    public String updateContent(@ModelAttribute("contents") ContentEntity content) {
        contentService.editContent(content);
        return "redirect:/content/";
    }
    @GetMapping("/delete/{id}")
    public String deleteContent(@PathVariable int id) {
        contentService.deleteContent(id);
        return "redirect:/content/";
    }
    @PostMapping("/search")
    public String search(@RequestParam("search") String search, Model model) {
        if(search != null) {
            model.addAttribute("titleContent", contentService.getByTitle(search));
        }else  {
            List<ContentEntity> list = contentService.getAllContent();
            model.addAttribute("list", list);
        }
        return "content/view-content";
    }
}