package com.example.assignment2_spring.model;

import com.example.assignment2_spring.validators.EmailConstraint;
import com.example.assignment2_spring.validators.PasswordConstraint;
import com.example.assignment2_spring.validators.PhoneConstraint;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class Register implements Serializable {
    @NotBlank(message = "Please input your username")
    private String username;

    @PasswordConstraint
    private String password;

    private String rePassword;

    @NotBlank(message = "Please input your firstName")
    private String firstName;

    @NotBlank(message = "Please input your lastName")
    private String lastName;

    @PhoneConstraint
    private String phone;

    @EmailConstraint
    private String email;
}