package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "is_active", columnDefinition = "boolean default true")
    private Boolean isActive;
    private String email;
    private String password;
}
