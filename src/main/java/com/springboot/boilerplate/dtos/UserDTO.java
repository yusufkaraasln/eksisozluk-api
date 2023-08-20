package com.springboot.boilerplate.dtos;

import com.springboot.boilerplate.entities.Entry;
import com.springboot.boilerplate.entities.User;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

        private User details;

        private List<Entry> entries;



}
