package com.example.picture_of_the_day_2.controller;


import com.example.picture_of_the_day_2.model.Comment;
import com.example.picture_of_the_day_2.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public String showIndexForm(Model model) {
        List<Comment> comments = commentService.findAll();
        model.addAttribute("comments", comments);
        model.addAttribute("comment", new Comment());
        return "index";
    }

    @PostMapping("/save")
    public String createComment(Comment comment) {
        commentService.save(comment);
        return "redirect:/";
    }
}
