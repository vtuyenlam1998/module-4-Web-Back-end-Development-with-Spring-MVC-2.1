package com.productmanagementthymeleaf.controller;

import com.productmanagementthymeleaf.model.Product;
import com.productmanagementthymeleaf.service.ProductService;
import com.productmanagementthymeleaf.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService = new ProductServiceImpl();

    @RequestMapping(value = "", method = {RequestMethod.GET})
    public String index(ModelMap model) {
        List<Product> productList = productService.showProductList();
        model.addAttribute("products", productList);
        return "index";
    }

    @RequestMapping(value = "/create", method = {RequestMethod.GET})
    public String create(Model model) {
        model.addAttribute("action", "create");
        model.addAttribute("product", new Product());
        return "form";
    }

    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public String save(Product product, RedirectAttributes redirect) {
        productService.saveProduct(product);
        redirect.addFlashAttribute("success", "Added product successfully!");
        return "redirect:/product";
    }

    @RequestMapping(value = "/edit{id}", method = {RequestMethod.GET})
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findProduct(id));
        model.addAttribute("action","update");
        return "form";
    }

    @PostMapping("/update")
    public String update(Product product) {
        productService.saveProduct(product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        productService.deleteProduct(productService.hashCode());
        model.addAttribute("product", productService.findProduct(id));
        model.addAttribute("action","delete");
        return "form";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.deleteProduct(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("action","view");
        model.addAttribute("product", productService.findProduct(id));
        return "form";
    }
}
