package com.gicwhorkshop.day9_24.Validation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<ValidAge, Integer> {

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext context) {
        if (age == null) return false;
        return age >= 18 && age <= 60;
    }
}
