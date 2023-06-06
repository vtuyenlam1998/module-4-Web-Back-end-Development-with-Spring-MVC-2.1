package com.example.payload.product;

import com.example.model.Category;
import com.example.model.Variant;
import lombok.*;

import java.util.List;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductListDto {
    private Long id;
    private String name;
    private String detail;
    private List<Variant> variants;
    private String image;
    private Category category;
}
