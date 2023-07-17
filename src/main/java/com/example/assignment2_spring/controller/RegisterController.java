package com.example.assignment2_spring.controller;

import com.example.assignment2_spring.model.Register;
import com.example.assignment2_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Objects;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private MemberService memberService;
    @GetMapping("")
    public String showRegister(Model model) {
        model.addAttribute("register",new Register());
        return "user/register";
    }
    @PostMapping("")
    public String doRegister(Model model,@Valid Register register, BindingResult br) {
//        if (br.hasErrors()) {
//            return "user/register";
//        }
//        if(memberService.isUsernameExist(register) != null) {
//            model.addAttribute("error", "Username already exists.");
//            return "user/register";
//        }
        memberService.register(register);
        return "redirect:/login";
    }
}
