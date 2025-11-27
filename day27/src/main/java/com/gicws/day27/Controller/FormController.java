package com.gicws.day27.Controller;

import com.gicws.day27.Validator.UserForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/form")
public class FormController {

    @PostMapping("/submit") // Correct answer for Q1
    public String handleSubmit(@Valid @ModelAttribute UserForm form) {
        return "success";
    }
}