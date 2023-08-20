package com.springboot.boilerplate.controllers;


import com.springboot.boilerplate.dtos.UserDTO;
import com.springboot.boilerplate.entities.User;
import com.springboot.boilerplate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public UserDTO getUserDetails() {
        return userService.getUserDetails();
    }

}
