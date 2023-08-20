package com.springboot.boilerplate.requests;

import lombok.Data;

@Data
public class SignUpRequest {


    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;


}