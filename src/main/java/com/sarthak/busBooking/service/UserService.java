package com.sarthak.busBooking.service;


import com.sarthak.busBooking.entity.User;
import com.sarthak.busBooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Object login(int userId, String password) {
        User user = repository.findById(userId).orElse(null);
        if (user == null) {
            return "User not found";
        }
        String userPass = user.getPassword();
        if (Objects.equals(userPass, password)) {
            return user;
        }
        return "User not found";
    }

    public User signup(String name, String password, String email) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        return repository.save(user);
    }

}