package com.example.assignment2_spring.controller;

import com.example.assignment2_spring.model.Register;
import com.example.assignment2_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {

    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("register", new Register());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("register") Register register, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }

        if (userService.isUsernameAvailable(register.getUsername())) {
            userService.registerUser(register.getUsername(), register.getPassword());
            return "redirect:/login";
        } else {
            result.rejectValue("username", "error.register", "Username already exists");
            return "register";
        }
    }
}
