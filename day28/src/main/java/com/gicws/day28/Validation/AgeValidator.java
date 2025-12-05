package com.gicws.day28.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<AgeValidation, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        Integer age;

        if (value instanceof Integer) {
            age = (Integer) value;
        } else if (value instanceof String) {
            String str = (String) value;

            // Check if numeric
            if (!str.matches("\\d+")) {
                return false;
            }

            age = Integer.parseInt(str);
        } else {
            return false;
        }

        return age >= 18 && age <= 60;
    }
}
