package com.example.controller;

import com.example.model.Post;
import com.example.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping
    public String index(Model model) {
        List<Post> posts = blogService.findAll();
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "create";
    }

    @PostMapping("/save")
    public ModelAndView savePost(@ModelAttribute("post") Post post) {
        blogService.save(post);
        ModelAndView modelAndView = new ModelAndView("redirect:/create");
        modelAndView.addObject("post",post);
        return modelAndView;
    }
}
