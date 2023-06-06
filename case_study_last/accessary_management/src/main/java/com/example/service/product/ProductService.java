package com.example.service.product;

import com.example.dto.product.ProductListDto;
import com.example.model.Product;
import com.example.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface ProductService extends IGeneralService<Product> {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
    void save(Product product);
    void softDelete(Long id);
    List<ProductListDto> findProducts();
}
