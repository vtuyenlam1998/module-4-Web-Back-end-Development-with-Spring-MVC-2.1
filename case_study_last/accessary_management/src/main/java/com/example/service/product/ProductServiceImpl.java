package com.example.service.product;

import com.example.dto.product.ProductListDto;
import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAllByIsActiveTrue();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findByIdAndIsActiveTrue(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void softDelete(Long productId) {
        productRepository.updateByIsActiveFalse(productId);
    }

    @Override
    public List<ProductListDto> findProducts() {
        List<Product> products = (List<Product>) productRepository.findAllByIsActiveTrue();
        return products.stream().
                map(element->modelMapper.map(element,ProductListDto.class)).collect(Collectors.toList());
    }
}
