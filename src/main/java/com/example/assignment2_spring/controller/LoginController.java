package com.example.assignment2_spring.controller;

import com.example.assignment2_spring.entity.MemberEntity;
import com.example.assignment2_spring.model.Login;
import com.example.assignment2_spring.service.ContentService;
import com.example.assignment2_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private ContentService contentService;
    @GetMapping("")
    public String showLogin(Model model) {
        model.addAttribute("login", new Login());
        model.addAttribute("listContent",contentService.getAllContent());
        return "user/login";
    }
    @PostMapping("")
    public String doLogin(@Valid Login login, BindingResult br, Model model) {
        if(br.hasErrors()) {
            return "user/login";
        }

        MemberEntity memberEntity = memberService.login(login);
        if(memberEntity == null) {
            model.addAttribute("error", "Incorrect Username & Password");
            return "user/login";
        }
        return "redirect:/content";
    }
}
