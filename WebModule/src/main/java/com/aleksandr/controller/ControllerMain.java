package com.aleksandr.controller;


import allProject.entity.Hobby;
import allProject.service.ContactService;
import com.aleksandr.ModelWeb.HobbyWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

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
        Set<Hobby> hobbies = contactService.getAllHobbies();
        Set<HobbyWeb> hobbyWebs = new HashSet<>();
        for (Hobby hobby : hobbies){
            hobbyWebs.add(new HobbyWeb(hobby.getId(), hobby.getTitle(), hobby.getDescription()));
        }
        modelAndView.addObject("hobbies", hobbyWebs);
        modelAndView.setViewName("index");
        System.out.println(hobbies.size());
        System.out.println(hobbyWebs.size());
        return modelAndView;
    }

}
