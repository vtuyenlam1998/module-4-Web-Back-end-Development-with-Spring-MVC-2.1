package com.productmanagementthymeleaf.service;

import com.productmanagementthymeleaf.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> showProductList();
    Product findProduct(int id);
    void saveProduct(Product product);
    void deleteProduct(int id);
}
