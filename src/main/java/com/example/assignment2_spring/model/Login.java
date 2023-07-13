package com.example.assignment2_spring.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Login {
    @NotBlank(message = "{username.not-blank}")
    private String username;
    @NotBlank(message = "{username.password}")
    private String password;
}
