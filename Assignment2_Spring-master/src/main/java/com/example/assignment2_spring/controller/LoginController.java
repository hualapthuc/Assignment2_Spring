package com.example.assignment2_spring.controller;

import com.example.assignment2_spring.model.Login;
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
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("login", new Login());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("login") Login login, BindingResult result) {
        if (result.hasErrors()) {
            return "login";
        }

        if (userService.authenticateUser(login.getUsername(), login.getPassword())) {
            return "redirect:/content/list";
        } else {
            result.rejectValue("username", "error.login", "Invalid username or password");
            return "login";
        }
    }
}
