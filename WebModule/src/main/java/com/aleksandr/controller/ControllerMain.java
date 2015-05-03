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

import javax.swing.*;
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

    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
    public @ResponseBody String deleteContact(@RequestParam(value = "contact", required = true) String contact){
        List<Contact> contacts = contactService.getAllContact();
        long idContact;
        String out = contact + " is not found";
        for (Contact contactWeb : contacts){
            if (contactWeb.getFirstName().equals(contact)){
                idContact=contactWeb.getId();
                contactService.deleteContact(contactWeb);
                out= contact+" with id "+idContact+ " is delete";
            }
        }
        return out;
    }

    @RequestMapping(value = "/deleteHobby", method = RequestMethod.GET)
    public @ResponseBody String deleteHobby(@RequestParam(value = "hobby", required = true) String hobby){
        Set<Hobby> hobbies = contactService.getAllHobbies();
        long idHobbies;
        String out = hobby + " is not found";
        for (Hobby hobby1 : hobbies){
            if (hobby1.getTitle().equals(hobby)){
                idHobbies=hobby1.getId();
                contactService.deleteHobby(hobby1);
                out= hobby+" with id "+idHobbies+ " is delete";
            }
        }
        return out;
    }

    @RequestMapping(value = "/deletePlace", method = RequestMethod.GET)
    public @ResponseBody String deletePlace(@RequestParam(value = "place", required = true) String place){
        Set<Place> places = contactService.getAllPlace();
        long idPlace;
        String out = place + " is not found";
        for (Place place1 : places){
            if (place1.getTitle().equals(place)){
                idPlace=place1.getId();
                contactService.deletePlace(place1);
                out= place+" with id "+idPlace+ " is delete";
            }
        }
        return out;
    }

    @RequestMapping(value = "/getAllContacts", method = RequestMethod.GET)
    public @ResponseBody
    List<ContactWeb> getAllContacts(){
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

     @RequestMapping(value = "/addMessage", method = RequestMethod.GET)
        public @ResponseBody String addMessage(@RequestParam(value = "contactFrom", required = true) String contactFrom,
                                               @RequestParam(value = "contactTo", required = true) String contactTo,
                                               @RequestParam(value = "newMessage", required = true) String newMessage ){
         long idFrom = -1;
         long idTo = -1;
         for (Contact contact : contactService.getAllContact()){
             if (contact.getFirstName().equals(contactFrom)){
                 idFrom=contact.getId();
             }
             if (contact.getFirstName().equals(contactTo)){
                 idTo=contact.getId();
             }
         }
        contactService.createNewMessageFromTo(newMessage, idFrom, idTo);
         JOptionPane.showMessageDialog(null, contactFrom + " " + contactTo + " " + newMessage + "\n were contactFrom= " + idFrom + " contactTo= " + idTo);
         String out= "Message "+newMessage + " send "+contactTo+" from "+contactFrom;
         return out;
    }


//    @RequestMapping(value = "/getAllMessage", method = RequestMethod.GET)
//        public @ResponseBody List<MessageWeb> getAllMessage(@RequestParam(value = "contact", required = true) String contact){
//        List<Message> messageList = contactService.getConversationToId(contactService.getIdContact(contact));
//        List<MessageWeb> messageWebList = new ArrayList<>();
//        for (Message message : messageList){
//            messageWebList.add(new MessageWeb(message.getFromId(), message.getContent()));
//        }
//        long idFrom = -1;
//        for (Contact contact1 : contactService.getAllContact()){
//            if (contact1.getFirstName().equals(contact)){
//                idFrom=contact1.getId();
//            }
//        }
//        List<MessageWeb> messageWebList1 = contactService.getConversationToId(idFrom);
//        return
//    }




}
