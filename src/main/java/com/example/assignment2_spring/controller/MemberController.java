package com.example.assignment2_spring.controller;

import com.example.assignment2_spring.entity.MemberEntity;
import com.example.assignment2_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @GetMapping("/edit-profile")
    public String editProfile(Model model) {
        return "member/edit-profile";
    }
    @GetMapping("/change-password")
    public String changPassword(Model model) {
        return "member/change-password";
    }
    @GetMapping("/view-profile")
    public String viewProfile(Model model) {
        return "member/view-profile";
    }
}
