package com.aleksandr.ModelWeb;


import java.util.Date;

/**
 * Created by Aleksandr on 25.03.2015.
 */

public class ContactWeb {


    private long id;

    private String firstName;

    private String lastName;

    private Date birthDate;

    public ContactWeb() {}

    public ContactWeb(long id) {
        this.id = id;
    }

    public ContactWeb(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public ContactWeb(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public ContactWeb(long id, String firstName, String lastName, Date birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public ContactWeb(String firstName) {
        this.firstName = firstName;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
