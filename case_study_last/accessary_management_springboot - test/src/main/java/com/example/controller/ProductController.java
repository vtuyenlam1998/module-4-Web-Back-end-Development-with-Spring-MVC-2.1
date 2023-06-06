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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
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

    @Value("${upload.path}")
    private String fileUpload;

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

    @GetMapping()
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
//        List<ProductListDto> products = productService.getAll();
        ModelAndView modelAttribute = new ModelAndView("admin/datatable");
        modelAttribute.addObject("products", productListDtos);
        modelAttribute.addObject("product", new ProductAddDto());
        modelAttribute.addObject("search", search.orElse(null));
        modelAttribute.addObject("pageable", pageable);
        return modelAttribute;
    }


    @GetMapping("/best-seller")
    public ModelAndView showBestSellerPage(@RequestParam("search") Optional<String> s, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("product/list");
        Page<Product> products = s.isPresent() ? search(s, pageable) : getPage(pageable);
        modelAndView.addObject("keyword", s.orElse(null));
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/create-product")
    public ModelAndView showCreatePage() {
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product", new ProductAddDto());
        return modelAndView;
    }

    @PostMapping("/create-product")
    public ModelAndView saveProduct(@ModelAttribute("product") ProductAddDto product) throws IOException {
        boolean isSaveSuccessfully = productService.save(product);
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product", new ProductAddDto());
        if (isSaveSuccessfully) {
            modelAndView.addObject("message", "New Product have been created successfully");
        }
        return modelAndView;

    }

    @GetMapping("/delete-product/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) throws Exception {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("product/delete");
            modelAndView.addObject("product", productOptional.get());
            return modelAndView;

        } else {
            return new ModelAndView("component/error-404");
        }
    }

    @PostMapping("/delete-product")
    public String deleteProduct(@ModelAttribute("product") Product product) {
        productService.softDelete(product.getId());
        return "redirect:/";
    }

    @GetMapping("/edit-product/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) throws Exception {
        Optional<ProductListDto> product = productService.findProductDtoById(id);
        if (product.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("product/edit");
            modelAndView.addObject("product", product.get());
            return modelAndView;
        } else {
            return new ModelAndView("component/error-404");
        }
    }

    @PostMapping("/edit-product")
    public ModelAndView updateCustomer(@ModelAttribute("product") Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("product/edit");
        modelAndView.addObject("product", product);
        modelAndView.addObject("message", "Product updated successfully");
        return modelAndView;
    }

}
