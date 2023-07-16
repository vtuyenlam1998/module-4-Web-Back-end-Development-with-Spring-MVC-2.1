package com.example.final_test.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Không được để trống")
    @Size(min=2,message = "tối thiểu 2 ký tự")
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id",nullable = false,referencedColumnName = "id")
    @JsonBackReference
    private Country country;

    @Min(value = 0,message = "Không được để số âm")
    private Double area;
    @Min(value = 0,message = "Không được để số âm")
    private Long population;
    @Min(value = 0,message = "Không được để số âm")
    private Double GDP;

    @Column(columnDefinition = "text")
    @NotBlank(message = "Không để trống")
    private String detail;

    @Column(name = "is_active", columnDefinition = "boolean default true")
    private Boolean isActive;

}
