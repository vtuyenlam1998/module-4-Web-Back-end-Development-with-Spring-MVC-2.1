package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @GetMapping
    public String home(Model model) {
        Iterable<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "index";
    }

    @PostMapping("/save")
    public ModelAndView save(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasFieldErrors()) {
            return new ModelAndView("create");
        } else {
            ModelAndView modelAndView = new ModelAndView("redirect:/");
            userService.save(user);
            redirectAttributes.addFlashAttribute("message","Create user successfullly");
            return modelAndView;
        }
    }
}
