package com.gicwhorkshop.day9_24.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

@Controller
public class AppController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/user/profile")
    public String userProfile(@AuthenticationPrincipal UserDetails user, Model model) {
        model.addAttribute("username", user.getUsername());
        return "userprofile1";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "adminDashboard";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
