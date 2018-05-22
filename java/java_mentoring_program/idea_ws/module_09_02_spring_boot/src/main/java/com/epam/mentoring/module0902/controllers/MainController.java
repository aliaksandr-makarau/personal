package com.epam.mentoring.module0902.controllers;

import com.epam.mentoring.module0902.services.SuperService;
import com.epam.mentoring.module0902.services.TaxiCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

@Controller
public class MainController {
    @Value("${application.message: Hi, Spring Booterrrrrrr!}")
    private String message = "Default message.";

    @Autowired
    private SuperService superService;

    @GetMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", message);
        return "welcome";
    }

    @GetMapping("/cabList")
    public ModelAndView getCabs() {
        ModelAndView model = new ModelAndView();
        model.addObject("cabs", superService.getCabs());
        model.setViewName("cabList");
        return model;
    }

    @Autowired
    private TaxiCompanyService taxiCompanyService;

    @GetMapping("/taxiCompany")
    public ModelAndView getTaxiCompany() {
        ModelAndView model = new ModelAndView();
        model.addObject("taxiCompanies", taxiCompanyService.findByName("Uber"));
        model.setViewName("taxiCompany");
        return model;
    }
}
