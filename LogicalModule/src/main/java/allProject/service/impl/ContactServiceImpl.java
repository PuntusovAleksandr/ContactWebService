package allProject.service.impl;

import allProject.dao.ContactDao;
import allProject.dao.HobbyDao;
import allProject.dao.MessageDao;
import allProject.dao.PlaceDao;
import allProject.entity.Contact;
import allProject.entity.Hobby;
import allProject.entity.Message;
import allProject.entity.Place;
import allProject.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Aleksandr on 04.04.2015.
 */
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDao contactDao;
    @Autowired
    private HobbyDao hobbyDao;
    @Autowired
    private PlaceDao placeDao;
    @Autowired
    private MessageDao messageDao;


    //ContactDao
    @Override
    @Transactional
    public void createContact(String firstName, String lastName, Date birthDate) {
        contactDao.addContact(new Contact(firstName, lastName, birthDate));
    }

    @Override
    @Transactional
    public void createContact(String firstName) {
        contactDao.addContact(new Contact(firstName));
    }

    @Override
    @Transactional
    public void addContact(Contact contact) {
        contactDao.addContact(contact);
    }

    @Override
    @Transactional
    public List<Contact> getAllContact() {
        return contactDao.getAllContact();
    }

    @Override
    @Transactional
    public Contact getContact(long id) {
        return contactDao.getContact(id);
    }

    @Override
    @Transactional
    public void deleteContact(Contact contact) {
        contactDao.deleteContact(contact);
    }

    @Override
    @Transactional
    public void addHobbyByContact(Contact contact, Hobby hobby) {
        contactDao.addHobbyByContact(contact, hobby);
    }

    @Override
    @Transactional
    public Set<Hobby> getHobbiesFromContact(Contact contact) {
        return contactDao.getHobbiesFromContact(contact);
    }

    @Override
    @Transactional
    public void addFriendship(Contact first, Contact second) {
        contactDao.addFrienfShip(first, second);
    }

    @Override
    @Transactional
    public List<Contact> getAllFriendsFromContact(Contact contact) {
        return contactDao.getAllFriendsFromContact(contact);
    }


    //HobbyDao
    @Override
    @Transactional
    public void createHobby(String title, String description) {
        hobbyDao.addHobby(new Hobby(title, description));
    }

    @Override
    @Transactional
    public void createHobby(Hobby hobby) {
        hobbyDao.addHobby(hobby);
    }

    @Override
    @Transactional
    public void addHobby(String title, String description) {
        hobbyDao.addHobby(new Hobby(title, description));
    }

    @Override
    @Transactional
    public void createHobby(String title) {
        hobbyDao.addHobby(new Hobby(title));
    }

    @Override
    @Transactional
    public Set<Hobby> getAllHobbies() {
        return hobbyDao.getAllHobbies();
    }

    @Override
    @Transactional
    public void deleteHobby(Hobby hobby) {
        hobbyDao.deleteHobby(hobby);
    }

    @Override
    @Transactional
    public Set<Contact> getAllContactsWithHobby(Hobby hobby) {
        return hobbyDao.getAllContactsWithHobby(hobby);
    }


    //PlaceDao
    @Override
    @Transactional
    public void createPlace(String title, String description, double longitude, double latitude){
        placeDao.addPlace(new Place(title, description, longitude, latitude));
    }

    @Override
    @Transactional
    public void createPlace(String title){
        placeDao.addPlace(new Place(title));
    }

    @Override
    @Transactional
    public void addPlace(Place place){
        placeDao.addPlace(place);
    }

    @Override
    @Transactional
    public void addPlace(String title, double v, double v1) {
        placeDao.addPlace(new Place(title, v , v1));
    }

    @Override
    @Transactional
    public void deletePlace(Place place) {
        placeDao.deletePlace(place);
    }

    @Override
    @Transactional
    public Set<Place> getAllPlace() {
        return placeDao.getAllPlace();
    }


    //MessageDao
    @Override
    @Transactional
    public void storeMessage(Message message) {

    }

    @Override
    @Transactional
    public List<Message> getConversation(Contact fromContact, Contact toContact) {
        return messageDao.getConversation(fromContact, toContact);
    }

    @Override
    @Transactional
    public List<Message> getConversationToId(long id) {
        return messageDao.getConversationToId(id);
    }

    @Override
    public List<String> getAllMessage() {
        return messageDao.getAllMessages();
    }

    @Override
    public void createNewMessageFromTo(String s, long id, long id1) {
        messageDao.createNewMessageFromTo( s, id, id1);
    }
}
