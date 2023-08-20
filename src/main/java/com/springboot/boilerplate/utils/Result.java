package com.springboot.boilerplate.utils;


import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private boolean success;
    private String message;
    private T data;



}
