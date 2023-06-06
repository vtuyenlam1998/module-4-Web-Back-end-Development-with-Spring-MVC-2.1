package com.example.payload.product;

import com.example.model.Category;
import com.example.model.Variant;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductAddDto {
    private Long id;
    private String name;
    private String detail;
    private MultipartFile image;
    private Category category;
}
