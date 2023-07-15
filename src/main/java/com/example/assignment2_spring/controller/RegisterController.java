package com.example.assignment2_spring.controller;

import com.example.assignment2_spring.entity.MemberEntity;
import com.example.assignment2_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private MemberService memberService;
    @GetMapping("")
    public String showRegister(Model model) {
        model.addAttribute("member",new MemberEntity());
        return "user/register";
    }
    @PostMapping("")
    public String doRegister(@ModelAttribute MemberEntity memberEntity) {
        memberService.register(memberEntity);
        return "redirect:/login";
    }
}