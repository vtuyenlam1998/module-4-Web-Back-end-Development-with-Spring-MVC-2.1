package com.example.service.product;

import com.example.model.Product;
import com.example.payload.product.ProductAddDto;
import com.example.payload.product.ProductListDto;
import com.example.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProductService extends IGeneralService<Product> {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id) throws Exception;
    boolean save(ProductAddDto product) throws IOException;
    List<Product> save(List<Product> products);
    boolean exists(Long id);

    List<Product> findAll(List<Long> ids);

    long count();
    void softDelete(Long id);
    Page<Product> findAll(Pageable pageInfo);

    List<Product> search(String keyword);

    Page<Product> search(String keyword, Pageable pageInfo);
    Page<ProductListDto> searchProductDto(String keyword, Pageable pageInfo);
    List<ProductListDto> getAll();
    Optional<ProductListDto> findProductDtoById(Long id) throws Exception;

    Page<ProductListDto> findAllProductDto(Pageable pageInfo);

    Product saveProduct(Product product);

    Optional<ProductAddDto> findProductAddDtoById(Long id) throws Exception;
}
