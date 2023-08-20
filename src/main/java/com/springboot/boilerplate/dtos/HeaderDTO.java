package com.springboot.boilerplate.dtos;

import com.springboot.boilerplate.entities.Entry;
import lombok.Data;

import java.util.List;

@Data
public class HeaderDTO {

    private String header;

    private List<Entry> entries;


}
