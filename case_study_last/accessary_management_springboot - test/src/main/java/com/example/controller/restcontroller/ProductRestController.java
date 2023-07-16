package com.example.controller.restcontroller;

import com.example.model.Product;
import com.example.payload.product.ProductListDto;
import com.example.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admins")
public class ProductRestController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAllCustomer() {
        List<Product> products = (List<Product>) productService.findAll();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createNewProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCustomerById(@PathVariable Long id) throws Exception {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeProduct(@PathVariable Long id) throws Exception {
        Optional<Product> product = productService.findById(id);
        if (product.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.softDelete(id);
        return new ResponseEntity<>(product.get(),HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id,@RequestBody Product product) throws Exception {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        product.setId(productOptional.get().getId());
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.OK);
    }
}
