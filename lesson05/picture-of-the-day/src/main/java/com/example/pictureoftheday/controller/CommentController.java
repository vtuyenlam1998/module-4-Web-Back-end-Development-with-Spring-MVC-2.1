package com.example.pictureoftheday.controller;

import com.example.pictureoftheday.model.Comment;
import com.example.pictureoftheday.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public String showIndexForm(Model model) {
        Iterable<Comment> comments = commentService.findAll();
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
