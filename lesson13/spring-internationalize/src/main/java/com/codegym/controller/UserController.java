package com.codegym.controller;

import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping
    public String home(Model model){
        model.addAttribute("user",new User());
        return "/login";
    }
    @PostMapping("/doLogin")
    public ModelAndView login(@ModelAttribute("user") User user){
        return new ModelAndView("/welcome");
    }
}
