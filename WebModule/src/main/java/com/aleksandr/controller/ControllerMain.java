package com.aleksandr.controller;


import allProject.entity.Contact;
import allProject.entity.Hobby;
import allProject.entity.Place;
import allProject.service.ContactService;
import com.aleksandr.ModelWeb.ContactWeb;
import com.aleksandr.ModelWeb.HobbyWeb;
import com.aleksandr.ModelWeb.PlaceWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class ControllerMain {

    @Autowired
    ContactService contactService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcomePage(){
        return "index";
    }




    @RequestMapping(value = "/addContact", method = RequestMethod.GET)
    public @ResponseBody long addContact(@RequestParam(value = "firstName", required = true) String firstName,
                                         @RequestParam(value = "lastName", required = false) String lastName,
                                         @RequestParam(value = "birthDate", required = false)Date birthDate){
        Contact contact = new Contact(firstName, lastName, birthDate);
        contactService.addContact(contact);
        return contact.getId();
    }

    @RequestMapping(value = "/addHobby", method = RequestMethod.GET)
    public @ResponseBody long addHobby(@RequestParam(value = "title", required = true) String title,
                                       @RequestParam(value = "description", required = false) String description){
        Hobby hobby = new Hobby(title, description);
        contactService.createHobby(hobby);
        return hobby.getId();
    }


    @RequestMapping(value = "/addPlace", method = RequestMethod.GET)
    public @ResponseBody long addPlace(@RequestParam(value = "title", required = true) String title,
                                       @RequestParam(value = "description", required = false) String description,
                                       @RequestParam(value = "longitude", required = false) String longitude,
                                       @RequestParam(value = "latitude", required = false) String latitude ){
        double longit, latid;
        if (longitude.equals("") || latitude.equals("")){
            longit=0.0;
            latid =0.0;
        }else {
            longit=Double.parseDouble(longitude);
            latid =Double.parseDouble(latitude);
        }
        Place place = new Place(title, description,longit,latid);
        contactService.addPlace(place);
        return place.getId();
    }




    @RequestMapping(value = "/getAllContacts", method = RequestMethod.GET)
    public @ResponseBody
    List<ContactWeb> detAllContacts(){
        List<Contact> contacts = contactService.getAllContact();
        List<ContactWeb> contactWebs = new ArrayList<>();
        for (Contact contact : contacts){
            contactWebs.add(new ContactWeb(contact.getId(), contact.getFirstName(), contact.getLastName(), contact.getBirthDate()));
        }
        return contactWebs;
    }


    @RequestMapping(value = "/getHobbies", method = RequestMethod.GET)
    public @ResponseBody Set<HobbyWeb> getAllHobby(){
        Set<Hobby> hobbies = contactService.getAllHobbies();
        Set<HobbyWeb> hobbyWebs = new HashSet<>();
        for (Hobby hobby : hobbies){
            hobbyWebs.add(new HobbyWeb(hobby.getId(), hobby.getTitle(), hobby.getDescription()));
        }
        return hobbyWebs;
    }


    @RequestMapping(value = "/getPlace", method = RequestMethod.GET)
    public @ResponseBody Set<PlaceWeb> getAllPlace(){
        Set<Place> places = contactService.getAllPlace();
        Set<PlaceWeb> placeWebs = new HashSet<>();
        for (Place place : places){
            placeWebs.add(new PlaceWeb(place.getId(), place.getTitle(), place.getDescription(), place.getLongitude() , place.getLatitude()));
        }
        return placeWebs;
    }

}
