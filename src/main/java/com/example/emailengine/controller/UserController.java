package com.example.emailengine.controller;

import com.example.emailengine.dto.UserDto;
import com.example.emailengine.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final NotificationService notificationService;
    // Static list to simulate database
    private final List<UserDto> users = Arrays.asList(
            new UserDto("Khaled", "khaledmohammed4000@icloud.com")
    );

    public UserController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/register")
    public String registerUser() {
        notificationService.sendWelcome(users);
        return "✅ User registered and welcome email sent.";
    }

    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        return  users;
    }
}
