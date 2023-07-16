package com.example.final_test.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "is_active", columnDefinition = "boolean default true")
    private Boolean isActive;

    @OneToMany(mappedBy = "country",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<City> cityList;
}
