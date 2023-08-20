package com.springboot.boilerplate.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum UserType {

    ADMIN("admin"),
    USER("user");

    @Getter
    private final String value;


}
