package com.example.model;

import javax.persistence.*;


@Entity
@Table(name = "admins", uniqueConstraints = {
        @UniqueConstraint(name = "admins_uk",
                columnNames = {"email"})})
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
