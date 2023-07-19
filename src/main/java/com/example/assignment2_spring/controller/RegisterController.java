package com.example.assignment2_spring.controller;

import com.example.assignment2_spring.entity.MemberEntity;
import com.example.assignment2_spring.model.Register;
import com.example.assignment2_spring.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {
//    @Autowired
//    private RegisterValidator registerValidator;
    @Autowired
    private MemberService memberService;

    @GetMapping("")
    public String showRegister(Model model) {
        model.addAttribute("register",new Register());
        return "user/register";
    }
    @PostMapping("")
    public String doRegister(Model model, @Valid @ModelAttribute("register") Register register, BindingResult br) {
        MemberEntity isEmailAvailable = memberService.findByEmail(register.getEmail());
        MemberEntity isUsernameAvailable = memberService.findByUsername(register.getUsername());
        if(isEmailAvailable != null) {
            br.rejectValue("email",null, "Your email already exists.");
        }
        if(isUsernameAvailable != null) {
            br.rejectValue("username",null, "Your username already exists.");
        }
        if (!register.getPassword().equals(register.getRePassword())) {
            br.rejectValue("rePassword", null, "Password & Confirm password don't match");
        }

        if (br.hasErrors()) {
            model.addAttribute("register", register);
            return "user/register";
        }
        memberService.register(register);
        return "user/register-success";
    }
}
