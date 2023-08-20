package com.springboot.boilerplate.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.boilerplate.enums.UserType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(unique = true, name = "username")

    private String username;
    private String name;
    private String surname;
    private String email;


    @JsonIgnore
    private String password;

    @Enumerated(EnumType.STRING)
    private UserType userType;


    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Entry> entries;


}
