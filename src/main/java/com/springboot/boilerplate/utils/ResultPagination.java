package com.springboot.boilerplate.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ResultPagination<T> {
    private boolean success;
    private String message;
    private T data;
    private Pagination pagination;
}
