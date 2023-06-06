package com.example.model;

import jakarta.persistence.*;


@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "is_active", columnDefinition = "boolean default true")
    private Boolean isActive;
    private String name;
    private String email;
    private String password;
}
