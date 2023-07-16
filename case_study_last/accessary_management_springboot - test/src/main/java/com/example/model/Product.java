package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "text")

    private String detail;
    @Column(length = 100)
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Variant> variants;

    @Column(name = "is_active", columnDefinition = "boolean default true")
    private Boolean isActive;

    @Column(columnDefinition = "text")
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",nullable = false,referencedColumnName = "id")
    @JsonBackReference
    private Category category;

    public Product(String detail, String name, List<Variant> variants, String image, Category category) {
        this.detail = detail;
        this.name = name;
        this.variants = variants;
        this.isActive = true;
        this.image = image;
        this.category = category;
    }

    public Product(String detail, String name, String image, Category category) {
        this.detail = detail;
        this.name = name;
        this.isActive = true;
        this.image = image;
        this.category = category;
    }

    public Product(Long id, String detail, String name, String image, Category category) {
        this.id = id;
        this.detail = detail;
        this.name = name;
        this.isActive = true;
        this.image = image;
        this.category = category;
    }
}
