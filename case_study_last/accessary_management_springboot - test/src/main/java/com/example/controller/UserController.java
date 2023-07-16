package com.example.controller;

import com.example.payload.product.ProductListDto;
import com.example.payload.user.RoleDto;
import com.example.payload.user.UserDto;
import com.example.service.product.ProductService;
import com.example.service.role.RoleService;
import com.example.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ProductService productService;

    @ModelAttribute("roleDtos")
    public Iterable<RoleDto> roleDtos(){
        return roleService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("home/signup");
        modelAndView.addObject("user", new UserDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveUser(@Validated @ModelAttribute("user") UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("home/signup");
        } else  {
            userService.save(userDto);
            ModelAndView modelAndView = new ModelAndView("home/login");
            modelAndView.addObject("user", new UserDto());
            modelAndView.addObject("message", "New user created successfully");
            return modelAndView;
        }
    }

    @GetMapping("/list")
    public ModelAndView listUsers(@RequestParam("search") Optional<String> search, Pageable pageable){
        Page<UserDto> userDtos;
        if(search.isPresent()){
            userDtos = userService.findAllByFullNameContaining(search.get(), pageable);
        } else {
            userDtos = userService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/user/list");
        modelAndView.addObject("userDtos", userDtos);
        return modelAndView;
    }


    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) throws Exception {
        Optional<UserDto> userDto = userService.findById(id);
        ModelAndView modelAndView;
        if (userDto.isPresent()) {
            modelAndView = new ModelAndView("/user/edit");
            modelAndView.addObject("userDto", userDto.get());
        } else {
            modelAndView = new ModelAndView("/error-404");
        }
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView updateUser(@ModelAttribute("userDto") UserDto userDto) {
        userService.save(userDto);
        ModelAndView modelAndView = new ModelAndView("/user/edit");
        modelAndView.addObject("roleDto", userDto.getRole());
        modelAndView.addObject("message", "User updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) throws Exception {
        Optional<UserDto> userDto = userService.findById(id);
        ModelAndView modelAndView;
        if (userDto.isPresent()) {
            modelAndView = new ModelAndView("/user/delete");
            modelAndView.addObject("userDto", userDto.get());
        } else {
            modelAndView = new ModelAndView("/error-404");
        }
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteUser(@ModelAttribute("user") UserDto userDto) {
        userService.softDelete(userDto.getId());
        return "redirect:list";
    }

    @GetMapping("/home")
    public ModelAndView showProductList(){
        ModelAndView modelAndView = new ModelAndView("product/home");
        List<ProductListDto> productListDtoList = productService.getAll();
        modelAndView.addObject("products",productListDtoList);
        return modelAndView;
    }
}