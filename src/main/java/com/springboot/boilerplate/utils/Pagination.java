package com.springboot.boilerplate.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Pagination {
    private int currentPage;
    private int lastPage;
    private long total;
    private boolean next;
    private boolean prev;


    public Pagination(int currentPage, int lastPage, long total) {
        this.currentPage = currentPage;
        this.lastPage = lastPage;
        this.total = total;
        this.next = lastPage > currentPage;
        this.prev = currentPage > 1;
    }

}
