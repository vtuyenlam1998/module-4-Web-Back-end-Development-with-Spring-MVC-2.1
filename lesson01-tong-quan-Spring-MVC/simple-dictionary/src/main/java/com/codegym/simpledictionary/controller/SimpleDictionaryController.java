package com.codegym.simpledictionary.controller;

import com.codegym.simpledictionary.service.SimpleDictionaryService;
import com.codegym.simpledictionary.service.impl.SimpleDictionaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimpleDictionaryController {
    @Autowired
    private SimpleDictionaryService simpleDictionaryService;
    @GetMapping("/translate")
    public ModelAndView translate(@RequestParam String english) {
        ModelAndView modelAndView = new ModelAndView("/translate");
        String vietnamese = simpleDictionaryService.searchTranslateWord(english);
        if (vietnamese == null) {
            modelAndView.addObject("message","Không tìm thấy nghĩa từ này!!!");
        } else {
            modelAndView.addObject("message",vietnamese);
        }
        return modelAndView;
    }
    @GetMapping("/")
    public ModelAndView showSimpleDictionary(){
        ModelAndView modelAndView = new ModelAndView("/translate");
        return modelAndView;
    }
}
