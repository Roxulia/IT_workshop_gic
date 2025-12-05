package com.gicws.day28.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AgeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AgeValidation {
    String message() default "Age must be between 18 and 60";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
