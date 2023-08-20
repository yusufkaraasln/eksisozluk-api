package com.springboot.boilerplate.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum UserType {

    ADMIN("ADMIN"),
    USER("USER");

    @Getter
    private final String value;


}
