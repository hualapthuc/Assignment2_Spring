package com.example.assignment2_spring.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class Register implements Serializable {
    @NotBlank(message = "Please input your username")
    private String userName;
    @NotBlank(message = "Please input your password")
    private String password;
    @NotBlank(message = "Please input your re-password")
    private String rePassword;
    @NotBlank(message = "Please input your firstName")
    private String firstName;
    @NotBlank(message = "Please input your lastName")
    private String lastName;
    @NotBlank(message = "Please input your phone")
    private String phone;
    @NotBlank(message = "Please input your email")
    private String email;
}
