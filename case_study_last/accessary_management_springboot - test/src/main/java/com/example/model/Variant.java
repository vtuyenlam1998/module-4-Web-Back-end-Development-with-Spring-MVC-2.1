package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "variants")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Variant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false,referencedColumnName = "id")
    @JsonBackReference
    private Product product;

    private String size;
    private Double price;
    private String originName;
    @Column(name = "is_active", columnDefinition = "boolean default true")
    private Boolean isActive;
}
