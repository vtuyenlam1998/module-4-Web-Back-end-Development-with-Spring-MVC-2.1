package com.productmanagementthymeleaf.service.impl;

import com.productmanagementthymeleaf.model.Product;
import com.productmanagementthymeleaf.service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static final Map<Integer,Product> products;
    static {
        products = new HashMap<>();
        products.put(1,new Product("Áo tùm lum lỗ",120000,"áo","chợ Đồng Xuân"));
        products.put(2,new Product("Áo lá",30000,"áo","chợ Đông Ba"));
        products.put(3,new Product("Quần què",350000,"quần","chợ Nguyễn Tất Thành"));
        products.put(4,new Product("Giày thể thao Niken",1500000,"giày","chợ Đồng Xuân"));
        products.put(5,new Product("Nón cối",220000,"nón","chợ Bình Tiên"));
        products.put(6,new Product("Giày thể thao a di đà",2050000,"giày","chợ Nguyễn Tất Thành"));
    }
    @Override
    public List<Product> showProductList() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findProduct(int id) {
        return products.get(id);
    }

    @Override
    public void saveProduct(Product product) {
//        Product originProduct = findProduct(product.getId());
//        if (originProduct == null) {
//            products.put(product.getId(), product);
//        }
        products.put(product.getId(),product);
    }

    @Override
    public void deleteProduct(int id) {
        products.remove(id);
    }
}
