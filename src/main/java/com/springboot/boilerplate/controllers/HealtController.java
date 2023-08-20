package com.springboot.boilerplate.controllers;


import com.springboot.boilerplate.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/health")
public class HealtController {


    @GetMapping("/ping")
    public Result<String> ping() {
        return new Result<>(true, "success", "pong");
    }


}
