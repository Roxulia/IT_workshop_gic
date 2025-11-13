package com.example.gicws2.demo.Controllers;

//import ch.qos.logback.core.model.Model;
import com.example.gicws2.demo.Classes.Users;
import com.example.gicws2.demo.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "userList";
    }

    @RequestMapping(value = "/submit", method = {RequestMethod.GET, RequestMethod.POST})
    public String handleForm(Model model) {
        model.addAttribute("message", "This method handles both GET and POST!");
        return "result";
    }

    @PostMapping("/submitForm")
    public String submitForm(@Valid @ModelAttribute("user") Users user,
                             BindingResult result,
                             Model model) {

        if (result.hasErrors()) {
            // Return form page with error messages
            return "userForm";
        }

        // Process valid user data
        model.addAttribute("message", "User data submitted successfully!");
        return "success";
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable int id, Model model) {
        Users user = userService.getUser(id);
        if (user != null) {
            model.addAttribute("user", user);
            return "userView";
        } else {
            return "error";
        }
    }



}
