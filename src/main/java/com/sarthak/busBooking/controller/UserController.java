package com.sarthak.busBooking.controller;

import com.sarthak.busBooking.entity.User;
import com.sarthak.busBooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public Object loginUser(@RequestBody Map<String, String> user) {
        return service.login(user.get("email"), user.get("password"));
    }

    @PostMapping("/signup")
    public User signupUser(@RequestBody Map<String, String> user) {
        return service.signup(user.get("name"), user.get("password"), user.get("email"));
    }

}
