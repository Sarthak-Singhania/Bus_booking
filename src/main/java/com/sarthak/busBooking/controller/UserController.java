package com.sarthak.busBooking.controller;

import com.sarthak.busBooking.entity.User;
import com.sarthak.busBooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public Object loginUser(@RequestBody Map<String, String> user) {
        return service.login(Integer.parseInt(user.get("id")), user.get("password"));
    }

    @PostMapping("/signup")
    public User signupUser(@RequestBody Map<String, String> user) {
        return service.signup(user.get("name"), user.get("password"), user.get("email"));
    }

}
