package com.example.readingpartner.controller;

import com.example.readingpartner.Response.LoginResponse;
import com.example.readingpartner.model.User;
import com.example.readingpartner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping("/register")
    public LoginResponse register(@RequestBody User user) {
        return userService.register(user);
    }
}
