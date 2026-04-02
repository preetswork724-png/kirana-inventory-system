package com.kirana.app.controller;

import com.kirana.app.model.LoginResponse;
import com.kirana.app.model.User;
import com.kirana.app.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*") // 🔥 ADD THIS
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody User user) {
        return service.login(user);
    }
}