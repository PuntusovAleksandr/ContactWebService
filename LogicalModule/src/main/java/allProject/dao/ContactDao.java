package allProject.dao;

import allProject.entity.Contact;

import java.util.List;

/**
 * Created by Aleksandr on 25.03.2015.
 */
public interface ContactDao {

    void addContact(Contact contact);
    List<Contact> getAllContact();
    Contact detContact(long id);

    void deleteContact(Contact contact);



}
