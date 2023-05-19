package com.example.store_email_configuration.controller;

import com.example.store_email_configuration.model.EmailConfig;
import com.example.store_email_configuration.service.EmailConfigsService;
import com.example.store_email_configuration.service.EmailConfigsServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/app")
public class EmailConfigsController {
    @Autowired
    private EmailConfigsService emailConfigsService;

    @GetMapping("")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("emailConfig",EmailConfig.getInstance());
        return modelAndView;
    }
    @GetMapping("/edit")
    public ModelAndView showEditForm(){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("emailConfig",EmailConfig.getInstance());
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("emailConfig") EmailConfig emailConfig,  RedirectAttributes redirectAttributes){
        emailConfigsService.saveEmailConfigs(emailConfig);
        redirectAttributes.addFlashAttribute("success","Edit email configuration successfully!");
        return "redirect:/app";
    }

}
