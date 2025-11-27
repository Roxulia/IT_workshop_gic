package com.gicws.day27.Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserForm form = (UserForm) target;

        if (form.getEmail() == null || !form.getEmail().contains("@")) {
            errors.rejectValue("email", "invalid.email", "Invalid email");
        }
    }
}
