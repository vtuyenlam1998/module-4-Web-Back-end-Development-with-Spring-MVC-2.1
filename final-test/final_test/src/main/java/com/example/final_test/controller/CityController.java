package com.example.final_test.controller;

import com.example.final_test.model.City;
import com.example.final_test.model.Country;
import com.example.final_test.service.city.CityService;
import com.example.final_test.service.country.CountryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("")
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryService;

    @ModelAttribute("countries")
    public Iterable<Country> countries() {
        return countryService.findAll();
    }

    @GetMapping("/list")
    public String showListCity(Model model) {
        Iterable<City> cities = cityService.findAll();
        model.addAttribute("cities", cities);
        return "city/list";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetailPage(@PathVariable("id") Long id) throws Exception {
        Optional<City> city = cityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("city/detail");
        modelAndView.addObject("city", city.orElse(null));
        return modelAndView;
    }

    @GetMapping("/create-city")
    public String showCreatePage(Model model) {
        model.addAttribute("city", new City());
        return "city/create";
    }

    @PostMapping("/create-city")
    public ModelAndView createCity(@Validated @ModelAttribute("city") City city,BindingResult bindingResult) {
            if (bindingResult.hasFieldErrors()) {
                return new ModelAndView("city/create");
            }
            cityService.save(city);
            ModelAndView modelAndView = new ModelAndView("city/create");
            modelAndView.addObject("message", "Nhập thành phố thành công");
            return modelAndView;
    }

    @GetMapping("/edit-city/{id}")
    public ModelAndView showEditPage(Model model, @PathVariable Long id) throws Exception {
        Optional<City> city = cityService.findById(id);
        if (city.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("city/edit");
            modelAndView.addObject("city", city.get());
            return modelAndView;
        } else {
            return new ModelAndView("component/error-404");
        }
    }

    @PostMapping("/edit-city")
    public ModelAndView editCity(@ModelAttribute City city) {
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("city/edit");
        modelAndView.addObject("city", city);
        modelAndView.addObject("message", "City updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-city/{id}")
    public ModelAndView showDeletePage(Model model, @PathVariable Long id) throws Exception {
        Optional<City> city = cityService.findById(id);
        if (city.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("city/delete");
            modelAndView.addObject("city", city.get());
            return modelAndView;
        } else {
            return new ModelAndView("component/error-404");
        }
    }

    @PostMapping("/delete-city/{id}")
    public ModelAndView deleteCity(@PathVariable Long id,RedirectAttributes redirectAttributes) {
        cityService.softDelete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        redirectAttributes.addFlashAttribute("message", "City deleted successfully");
        return modelAndView;
    }
}
