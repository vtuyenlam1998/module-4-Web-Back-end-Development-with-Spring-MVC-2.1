package com.example.service.product;

import com.example.model.Product;
import com.example.payload.product.ProductAddDto;
import com.example.payload.product.ProductListDto;
import com.example.repository.ProductRepository;
import com.example.repository.VariantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private VariantRepository variantRepository;

    @Value("${upload.path}")
    private String fileUpload;

    @Override
    public Iterable<Product> findAll() {
        System.out.println(productRepository.findByIsActiveTrue());
        return productRepository.findByIsActiveTrue();
    }

    @Override
    public Optional<Product> findById(Long id) throws Exception {
        Optional<Product> productOptional = productRepository.findByIdAndIsActiveTrue(id);
        if (productOptional.isEmpty()) {
            throw new Exception("product not found!");
        }
        return productOptional;
    }

    @Override
    public boolean save(ProductAddDto product) throws IOException {
        MultipartFile multipartFile = product.getImage();
        String fileName = multipartFile.getOriginalFilename();
        assert fileName != null;
        FileCopyUtils.copy(product.getImage().getBytes(), new File(fileUpload + fileName));
        Product product1 = new Product(product.getDetail(), product.getName(), fileName, product.getCategory());
        productRepository.save(product1);
        return true;
    }

    @Override
    public Product save(Product product) {
        product.setIsActive(true);
        productRepository.save(product);
        return product;
    }

    @Override
    public List<Product> save(List<Product> products) {
        Iterable<Product> updatedProducts = productRepository.saveAll(products);
        return streamAll(updatedProducts).collect(Collectors.toList());
    }

    @Override
    public boolean exists(Long id) {
        return productRepository.existsById(id);
    }

    @Override
    public List<Product> findAll(List<Long> ids) {
        Iterable<Product> customers = productRepository.findAllById(ids);
        return streamAll(customers).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return productRepository.count();
    }

    @Override
    public void softDelete(Long productId) {
        productRepository.updateByIsActiveFalse(productId);
    }

    public List<ProductListDto> getAll() {
        List<Product> products = (List<Product>) findAll();
        return products.stream().map(product -> modelMapper.map(product, ProductListDto.class)).collect(Collectors.toList());
    }

    @Override
    public Page<Product> findAll(Pageable pageInfo) {
        return productRepository.findAll(pageInfo);
    }

    @Override
    public List<Product> search(String keyword) {
        Iterable<Product> searchProduct = productRepository.findAllByNameContainsOrCategoryContains(keyword, keyword);
        return streamAll(searchProduct).collect(Collectors.toList());
    }

    @Override
    public Page<Product> search(String keyword, Pageable pageInfo) {
        return productRepository
                .findAllByNameContainsOrCategoryNameContains(keyword, keyword, pageInfo);
    }

    @Override
    public Page<ProductListDto> searchProductDto(String keyword, Pageable pageInfo) {
        Page<Product> products = productRepository
                .findAllByNameContainsOrCategoryNameContains(keyword, keyword, pageInfo);
        return products.map(product -> modelMapper.map(product, ProductListDto.class));
    }

    private Stream<Product> streamAll() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false);
    }

    private Stream<Product> streamAll(Iterable<Product> customers) {
        return StreamSupport.stream(customers.spliterator(), false);
    }


    public Optional<ProductListDto> findProductDtoById(Long id) throws Exception {
        Optional<Product> product = findById(id);
        return product.map(product1 -> modelMapper.map(product1, ProductListDto.class));
    }

    @Override
    public Page<ProductListDto> findAllProductDto(Pageable pageInfo) {
        //
        Page<Product> products = productRepository.findAll(pageInfo);
        return products.map(product -> modelMapper.map(product, ProductListDto.class));
    }
}
