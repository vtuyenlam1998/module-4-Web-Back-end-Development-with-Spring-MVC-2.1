package com.example.converter;

import com.example.model.Product;
import com.example.payload.product.ProductAddDto;
import com.example.payload.product.ProductListDto;
import org.springframework.beans.BeanUtils;

public class ProductConverter {
    public static ProductAddDto convertToAddDto(Product product) {
        ProductAddDto dto = new ProductAddDto();
        BeanUtils.copyProperties(product, dto);
        return dto;
    }
    public static ProductListDto convertToListDto(Product product) {
        ProductListDto dto = new ProductListDto();
        BeanUtils.copyProperties(product, dto);
        return dto;
    }

    public static Product addDtoConvertToEntity(ProductAddDto dto) {
        Product product = new Product();
        BeanUtils.copyProperties(dto, product);
        return product;
    }

    public static Product listDtoConvertToEntity(ProductListDto dto) {
        Product product = new Product();
        BeanUtils.copyProperties(dto, product);
        return product;
    }
}
