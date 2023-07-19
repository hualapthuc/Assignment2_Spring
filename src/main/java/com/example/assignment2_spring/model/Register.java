package com.example.assignment2_spring.model;

//import com.example.assignment2_spring.utils.validators.RegisterConstraint;
import com.example.assignment2_spring.utils.validators.EmailConstraint;
import com.example.assignment2_spring.utils.validators.PasswordConstraint;
import com.example.assignment2_spring.utils.validators.PhoneConstraint;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class Register implements Serializable {
    @NotBlank(message = "{username.not-blank}")
    private String username;

    @PasswordConstraint
    private String password;

    private String rePassword;

    @NotBlank(message = "{firstName.not-blank}")
    private String firstName;

    @NotBlank(message = "{lastName.not-blank}")
    private String lastName;

    @PhoneConstraint
    private String phone;

    @EmailConstraint
    private String email;
}
