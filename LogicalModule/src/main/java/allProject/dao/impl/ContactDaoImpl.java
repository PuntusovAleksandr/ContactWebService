package allProject.dao.impl;

import allProject.dao.ContactDao;
import allProject.entity.Contact;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
//        return (Contact) sessionFactory.getCurrentSession().createQuery("from contact where contact.id = :id").uniqueResult();
        return null;
    }

    @Override
    @Transactional
    public void deleteContact(Contact contact) {
        sessionFactory.getCurrentSession().delete(contact);
    }
}
