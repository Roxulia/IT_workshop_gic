package com.gicws.day26.Controller;

import com.gicws.day26.DataClass.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute UserForm userForm) {
        System.out.println("Received form data:");
        System.out.println("Name: " + userForm.getName());
        System.out.println("Email: " + userForm.getEmail());

        // Do something with userForm, e.g., save to DB
        return "success"; // return view name
    }
}
