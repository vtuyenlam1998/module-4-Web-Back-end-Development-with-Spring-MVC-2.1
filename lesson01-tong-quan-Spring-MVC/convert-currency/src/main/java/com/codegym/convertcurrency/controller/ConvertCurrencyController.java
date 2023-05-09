package com.codegym.convertcurrency.controller;

import com.codegym.convertcurrency.service.impl.ConvertCurrencyService;
import com.codegym.convertcurrency.service.impl.ConvertCurrencyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ConvertCurrencyController {
    @Autowired
    private ConvertCurrencyService convertCurrencyService;
    @GetMapping ("/convert")
    public ModelAndView convert(@RequestParam double numberUSD,double rate) {
        ModelAndView modelAndView = new ModelAndView("convert/convert");
        double currency = convertCurrencyService.convertToVND(numberUSD,rate);
        modelAndView.addObject("convert",currency);
        return modelAndView;
    }
    @GetMapping("/")
    public ModelAndView showConvertForm(){
        ModelAndView modelAndView = new ModelAndView("convert/convert");
        modelAndView.addObject("numberUSD",null);
        modelAndView.addObject("rate",25000);
        return modelAndView;
    }
}
