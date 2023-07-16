package com.example.payload.product;

import com.example.model.Category;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductAddDto {
    private Long id;
    @NotBlank(message = "Không được để trống")
    @Size(min = 5, max = 50, message = "Số lượng từ trong 5-50")
    private String name;
    @Size(max = 50, message = "Số lượng chữ tối đa là 50")
    private String detail;
    private MultipartFile image;
    private Category category;
}
