package com.example.assignment2_spring.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class Login implements Serializable {
    @NotBlank(message = "Please input your username")
    private String username;
    @NotBlank(message = "Please input your password")
    private String password;
}