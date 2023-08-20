package com.springboot.boilerplate.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "entries")
public class Entry {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "headers_id", referencedColumnName = "id")
    @JsonBackReference
    private Header header;

    private String content;

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;


    @Column(name = "created_at")

    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

}
