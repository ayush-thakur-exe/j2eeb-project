package com.bienvenu.controller;

import com.bienvenu.model.User;
import com.bienvenu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/auth/login")
    public String login() {
        return "user/login";
    }

    @GetMapping("/auth/logout")
    public String logout() {
        return "user/logout";
    }

    // TODO: Send and retrieve user object for signup
    @GetMapping("/auth/create")
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "user/create";
    }

    @PostMapping("/login")
    public void processLogin(){
        System.out.println("Someone tried to login");
    }

    @PostMapping("/signup")
    public String processSignup(@ModelAttribute("user") User user){
        userService.create(user);
        return "redirect:/auth/login";
    }
}
