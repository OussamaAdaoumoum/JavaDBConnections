package com.example.sprigdatajpa.controller;

import com.example.sprigdatajpa.model.UserRecord;
import com.example.sprigdatajpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public List<UserRecord> getAllUser()
    {
        return userService.getAllUsers();
    }
    @PostMapping("/add-user")
    public void addUser(@RequestBody UserRecord userRecord)
    {
        userService.addUser(userRecord);
    }
}
