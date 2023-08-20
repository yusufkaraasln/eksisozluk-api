package com.springboot.boilerplate.controllers;

import com.springboot.boilerplate.entities.User;
import com.springboot.boilerplate.requests.SignInRequest;
import com.springboot.boilerplate.requests.SignUpRequest;
import com.springboot.boilerplate.services.AuthService;
import com.springboot.boilerplate.utils.Result;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {


    private AuthService authService;

    @PostMapping("/sign-in")
    public ResponseEntity login(@RequestBody SignInRequest body) {

        try {
            Result<String> result = authService.signin(body.getEmail(), body.getPassword());
            return ResponseEntity.ok(result);
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.badRequest().body(new Result<>(false, "error", "User not found"));
        }

    }

    @PostMapping("/sign-up")
    public ResponseEntity register(@RequestBody SignUpRequest body)  {
        try {
            Result<User> result = authService.signup(body.getEmail(), body.getPassword(), body.getName(), body.getSurname(), body.getUsername());
            return ResponseEntity.ok(result);
        } catch ( RuntimeException e) {
            return ResponseEntity.badRequest().body(new Result<>(false, "error", "User already exists"));
        }


    }

}