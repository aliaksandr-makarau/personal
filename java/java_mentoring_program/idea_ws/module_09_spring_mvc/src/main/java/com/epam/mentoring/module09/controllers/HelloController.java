package com.epam.mentoring.module09.controllers;

import com.epam.mentoring.module09.services.CabsHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    private CabsHelloService cabsHelloService;

    @Autowired
    public void setCabsHelloService(CabsHelloService cabsHelloService) {
        this.cabsHelloService = cabsHelloService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView mAV = new ModelAndView();
        mAV.addObject("cab_name", cabsHelloService.getRandomCabName());
        mAV.addObject("cabs", cabsHelloService.getCabs());
        mAV.setViewName("main");
        return mAV;
    }
}
