package com.example.controller;

import com.example.payload.user.UserDto;
import com.example.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("home/login");
        modelAndView.addObject("user", new UserDto());
        return modelAndView;
    }

    @GetMapping("/access-denied")
    public ModelAndView accessDenied() {
        ModelAndView modelAndView = new ModelAndView("component/error-403");
        return modelAndView;
    }

    @GetMapping("/not-found")
    public ModelAndView notFound() {
        ModelAndView modelAndView = new ModelAndView("component/error-404");
        return modelAndView;
    }

    @PostMapping("/signup")
    public ModelAndView signup(@Validated @ModelAttribute("user") UserDto userDto, RedirectAttributes redirectAttributes, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("home/login");
        } else {
            userService.save(userDto);
            ModelAndView modelAndView = new ModelAndView("redirect:/login");
            redirectAttributes.addFlashAttribute("user",userDto);
            modelAndView.addObject("message", "New user created successfully");
            return modelAndView;
        }
    }
}
