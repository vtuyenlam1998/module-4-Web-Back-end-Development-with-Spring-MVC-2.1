package com.example.controller;

import com.example.model.Category;
import com.example.model.Product;
import com.example.model.Variant;
import com.example.payload.product.ProductAddDto;
import com.example.payload.product.ProductListDto;
import com.example.service.category.CategoryService;
import com.example.service.product.ProductService;
import com.example.service.variant.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private VariantService variantService;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }

    @ModelAttribute("variants")
    public Iterable<Variant> variants() {
        return variantService.findAll();
    }

    private Page<Product> getPage(org.springframework.data.domain.Pageable pageInfo) {
        return productService.findAll(pageInfo);
    }

    private Page<Product> search(Optional<String> s, org.springframework.data.domain.Pageable pageInfo) {
        return productService.search(s.get(), pageInfo);
    }

    @GetMapping({"","/home"})
    public ModelAndView home(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                             @RequestParam(name = "size", required = false, defaultValue = "3") Integer size,
                             @RequestParam(name = "sort", required = false, defaultValue = "name: ASC") String sort,
                             @RequestParam("search") Optional<String> search) {
        Sort sortable = null;
        int indexOfSortType = sort.indexOf(":");
        String sortType = sort.substring(0, indexOfSortType);
        if (sort.contains("ASC")) {
            sortable = Sort.by(sortType).ascending();
        }
        if (sort.contains("DESC")) {
            sortable = Sort.by(sortType).descending();
        }
        Pageable pageable = PageRequest.of(page, size, sortable);
        Page<ProductListDto> productListDtos;
        if (search.isPresent()) {
            productListDtos = productService.searchProductDto(search.get(), pageable);
        } else {
            productListDtos = productService.findAllProductDto(pageable);
        }
        ModelAndView modelAttribute = new ModelAndView("home/datatable");
        modelAttribute.addObject("products", productListDtos);
        modelAttribute.addObject("product", new ProductAddDto());
        modelAttribute.addObject("search", search.orElse(null));
        modelAttribute.addObject("pageable", pageable);
        return modelAttribute;
    }


    @GetMapping("/best-seller")
    public ModelAndView showBestSellerPage(@RequestParam("search") Optional<String> s, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("product/best-seller");
        List<ProductListDto> products = productService.getAll();
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/product/create-product")
    public ModelAndView showCreatePage() {
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product", new ProductAddDto());
        return modelAndView;
    }

    @PostMapping("/product/create-product")
    public ModelAndView saveProduct(@Validated @ModelAttribute("product") ProductAddDto product, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("product/create");
        } else {
            boolean isSaveSuccessfully = productService.save(product);
            ModelAndView modelAndView = new ModelAndView("product/create");
            modelAndView.addObject("product", new ProductAddDto());
            if (isSaveSuccessfully) {
                modelAndView.addObject("message", "New Product have been created successfully");
            }
            return modelAndView;
        }
    }

//    @GetMapping("/product/delete-product/{id}")
//    public ModelAndView showDeleteForm(@PathVariable Long id) throws Exception {
//        Optional<Product> productOptional = productService.findById(id);
//        if (productOptional.isPresent()) {
//            ModelAndView modelAndView = new ModelAndView("product/delete");
//            modelAndView.addObject("product", productOptional.get());
//            return modelAndView;
//
//        } else {
//            return new ModelAndView("component/error-404");
//        }
//    }

    @GetMapping("/product/delete-product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.softDelete(id);
        return "redirect:/";
    }

    @GetMapping("/product/edit-product/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) throws Exception {
        Optional<ProductAddDto> product = productService.findProductAddDtoById(id);
        if (product.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("product/edit");
            modelAndView.addObject("product", product.get());
            return modelAndView;
        } else {
            return new ModelAndView("component/error-404");
        }
    }

    @PostMapping("/product/edit-product")
    public ModelAndView updateCustomer(@ModelAttribute("product") ProductAddDto product) throws IOException {
        boolean isEditSuccessfully = productService.save(product);
        ModelAndView modelAndView = new ModelAndView("product/edit");
        modelAndView.addObject("product", product);
        if (isEditSuccessfully) {
            modelAndView.addObject("message", "Product updated successfully");
        } else modelAndView.addObject("message", "Edited product fail");
        return modelAndView;
    }

}
