package com.gicws.day28.Controller;

import com.gicws.day28.DataObjects.UserData;
import com.gicws.day28.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/users")

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String userList(Model model)
    {
        List<UserData> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "userList";
    }

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user", new UserData());
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") UserData userData,
                               BindingResult result,
                               RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            //model.addAttribute("error", "Validation errors occurred");
            return "registration";
        }

        try {
            userService.createUser(userData);
            redirectAttributes.addFlashAttribute("user", userData);
            return "redirect:/users/success";
        } catch (Exception e) {
            //model.addAttribute("error", e.getMessage());
            return "registration";
        }
    }

    @GetMapping("/success")
    public String registrationSuccess(Model model) {
        return "registrationSuccess";
    }
}
