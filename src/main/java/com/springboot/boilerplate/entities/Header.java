package com.springboot.boilerplate.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "headers")
public class Header {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title", length = 100, unique = true)
    private String title;

    @OneToMany(mappedBy = "header")
    @JsonManagedReference
    private List<Entry> entries;


}
