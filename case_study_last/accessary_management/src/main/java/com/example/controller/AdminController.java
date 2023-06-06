package com.example.controller;

import com.example.dto.admin.AdminLoginDto;
import com.example.model.Admin;
import com.example.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @GetMapping
    public String login(Model model){
        model.addAttribute("admin",new AdminLoginDto());
        return "/customer/login";
    }

    @GetMapping("/list")
    public String showAllEmailAndPassword(Model model){
        List<AdminLoginDto> adminLoginDtos = adminService.findAllByEmailAndPassword();
        model.addAttribute("logins",adminLoginDtos);
        return "/customer/list";
    }

}
