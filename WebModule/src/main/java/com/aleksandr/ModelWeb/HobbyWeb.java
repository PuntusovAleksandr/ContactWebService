package com.aleksandr.ModelWeb;

import allProject.entity.Contact;

import java.util.Set;

/**
 * Created by Aleksandr on 25.03.2015.
 */

public class HobbyWeb {

    private long id;

    private String title;

    private String description;

    private Set<allProject.entity.Contact> contacts;


    public HobbyWeb() {    }

    public HobbyWeb(String title) {
        this.title = title;
    }

    public HobbyWeb(String title, String description) {
        this.title = title;
        this.description = description;
    }


    public HobbyWeb(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<allProject.entity.Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }
}
