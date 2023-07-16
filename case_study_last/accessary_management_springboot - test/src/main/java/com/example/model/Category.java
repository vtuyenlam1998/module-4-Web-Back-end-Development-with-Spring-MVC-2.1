package com.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "is_active", columnDefinition = "boolean default true")
    private Boolean isActive;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Product> products;
}
