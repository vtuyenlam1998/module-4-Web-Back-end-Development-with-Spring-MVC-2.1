package com.example.controller;

import com.example.model.Category;
import com.example.model.Product;
import com.example.service.category.CategoryService;
import com.example.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping()
    public ModelAndView home() {
        Iterable<Product> products = productService.findAll();
        ModelAndView modelAttribute = new ModelAndView("/product/home");
        modelAttribute.addObject("products", products);
        return modelAttribute;
    }

    @GetMapping("/invoice")
    public String invoice(){
        return "/order/invoice";
    }
}
