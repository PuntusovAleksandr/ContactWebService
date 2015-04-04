package allProject.dao.impl;

import allProject.dao.ContactDao;
import allProject.entity.Contact;
import allProject.entity.Hobby;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Aleksandr on 25.03.2015.
 */
@Repository
public class ContactDaoImpl implements ContactDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addContact(Contact contact) {
        if (contact==null) throw new IllegalArgumentException("Contact must be valid");
        sessionFactory.getCurrentSession().saveOrUpdate(contact);

    }

    @Override
    @Transactional
    public List<Contact> getAllContact() {
        List<Contact> contactList = sessionFactory.getCurrentSession().createQuery("from Contact").list();
        if (contactList == null) {
            return null;
        }
        return contactList;
    }

    @Override
    @Transactional
    public Contact getContact(long id) {
        Contact contact = (Contact) sessionFactory.getCurrentSession().get(Contact.class, id);
        return contact;
    }

    @Override
    @Transactional
    public void deleteContact(Contact contact) {
        if (contact==null) throw new IllegalArgumentException("Contact must be valid");
        sessionFactory.getCurrentSession().delete(contact);
    }

    @Override
    @Transactional
    public void addHobbyByContact(Contact contact, Hobby hobby) {
        contact.getHobbies().add(hobby);
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
    }

    @Override
    @Transactional
    public Set<Hobby> getHobbiesFromContact(Contact contact) {
        if (contact==null) throw new IllegalArgumentException("Contact must be valid");
        return contact.getHobbies();
    }

    @Override
    @Transactional
    public void addFrienfShip(Contact first, Contact second) {
        if (first==null) throw new IllegalArgumentException("Contact must be valid");
        if (second==null) throw new IllegalArgumentException("Contact must be valid");

        first.getFriends().add(second);
        second.getFriends().add(first);
        sessionFactory.getCurrentSession().saveOrUpdate(first);
        sessionFactory.getCurrentSession().saveOrUpdate(second);
    }

    @Override
    @Transactional
    public List<Contact> getAllFriendsFromContact(Contact contact) {
        String stringQuery = " from LIST_FRIENDS where CONTACT_ID_ONE="+contact.getId();
        return sessionFactory.getCurrentSession().createQuery(stringQuery).list();
    }


}
