package com.example.assignment2_spring.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordConstraint {
    String message() default "Invalid Password (A password has a minimum of 6 CHARACTERS, at least 1 UPPERCASE LETTER, 1 LOWERCASE LETTER, and 1 NUMBER with no SPACES)";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
