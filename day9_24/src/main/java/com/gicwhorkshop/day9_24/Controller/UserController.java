package com.gicwhorkshop.day9_24.Controller;

import com.gicwhorkshop.day9_24.DTO.UserDTO;
import com.gicwhorkshop.day9_24.DTO.UserFormDTO;
import com.gicwhorkshop.day9_24.Service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable Long id, Model model) {

        UserDTO userDTO = userService.getUserById(id);

        model.addAttribute("user", userDTO);

        return "userProfile"; // thymeleaf template name
    }

    @GetMapping("/user/form")
    public String showForm(Model model) {
        model.addAttribute("userForm", new UserFormDTO());
        return "userForm";
    }

    @PostMapping("/user/form")
    public String submitForm(
            @Valid @ModelAttribute("userForm") UserFormDTO userForm,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "userForm"; // return form with errors
        }

        model.addAttribute("message", "Form submitted successfully!");
        return "formSuccess";
    }

    @PostMapping("/updateUser")
    @Transactional
    public String updateUser(@ModelAttribute UserDTO user) {
        userService.updateUser(user);
        return "redirect:/userList";
    }
}
