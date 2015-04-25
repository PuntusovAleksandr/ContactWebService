package com.aleksandr.controller;


import allProject.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerMain {

    @Autowired
    ContactService contactService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcomePage(){
        return "index";
    }



    @RequestMapping(value = "/#get_all_hobbies", method = RequestMethod.GET)
    public ModelAndView getAllHobbies(){
        ModelAndView modelAndView = new ModelAndView();
//        Set<Hobby> hobbies = contactService.getAllHobbies();
//
//        modelAndView.addObject("hobbies", hobbies);
//        modelAndView.setViewName("contacts");
        return modelAndView;
    }
}
