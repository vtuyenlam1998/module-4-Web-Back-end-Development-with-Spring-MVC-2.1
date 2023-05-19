package com.example.personalcomputer.controller;

import com.example.personalcomputer.service.CalculatorService;
import com.example.personalcomputer.service.impl.CalculatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService = new CalculatorServiceImpl();
    @RequestMapping(value = "")
    public String home(){
        return "index";
    }
    @RequestMapping(value = "/calculate")
    public String calculate(@RequestParam String operator, double firstOperand, double secondOperand, ModelMap model) {
        StringBuilder result = calculatorService.calculate(firstOperand,secondOperand,operator);
        model.addAttribute("firstOperand",firstOperand);
        model.addAttribute("secondOperand",secondOperand);
        model.addAttribute("operator",operator);
        model.addAttribute("result",result);
        return "calculate";
    }
}
