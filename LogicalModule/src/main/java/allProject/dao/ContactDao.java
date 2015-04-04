package allProject.dao;

import allProject.entity.Contact;
import allProject.entity.Hobby;

import java.util.List;
import java.util.Set;

/**
 * Created by Aleksandr on 25.03.2015.
 */
public interface ContactDao {

    void addContact(Contact contact);
    List<Contact> getAllContact();
    Contact getContact(long id);
    void deleteContact(Contact contact);


    void addHobbyByContact(Contact contact, Hobby hobby);

    Set<Hobby> getHobbiesFromContact(Contact contact);

    void addFrienfShip(Contact first, Contact second);

    List<Contact> getAllFriendsFromContact(Contact contact);
}
