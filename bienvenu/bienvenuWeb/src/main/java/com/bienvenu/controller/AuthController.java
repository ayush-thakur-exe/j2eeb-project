package com.bienvenu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

    @GetMapping("/auth/login")
    public String login() {
        return "user/login";
    }

    @GetMapping("/auth/logout")
    public String logout() {
        return "user/logout";
    }

    @PostMapping("/login")
    public void processLogin(){
        System.out.println("Someone tried to login");
    }
}
