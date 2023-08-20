package com.springboot.boilerplate.requests;

import lombok.*;

@Data
public class SignInRequest {
    private String email;
    private String password;

}