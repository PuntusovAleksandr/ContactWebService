package allProject.service;

import allProject.entity.Contact;
import allProject.entity.Hobby;
import allProject.entity.Message;
import allProject.entity.Place;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Aleksandr on 25.03.2015.
 */
public interface ContactService {
    //ContactDao
    void createContact(String firstName, String lastName, Date birthDate);

    @Transactional
    void createContact(String firstName);

    void addContact(Contact contact);
    List<Contact> getAllContact();
    Contact getContact(long id);
    void deleteContact(Contact contact);

    void addHobbyByContact(Contact contact, Hobby hobby);

    Set<Hobby> getHobbiesFromContact(Contact contact);
    void addFriendship(Contact first, Contact second);
    List<Contact> getAllFriendsFromContact(Contact contact);


    //HobbyDao
    public void createHobby(String title, String description);

    void createHobby(Hobby hobby);

    void addHobby(String title, String description);

    @Transactional
    void createHobby(String title);
    @Transactional
    Set<Hobby> getAllHobbies();
    void deleteHobby(Hobby hobby);

    @Transactional
    Set<Contact> getAllContactsWithHobby(Hobby hobby);

    //PlaceDao
    void createPlace(String title, String description, double longitude, double latitude);

    @Transactional
    void createPlace(String title);

    @Transactional
    void addPlace(Place place);

    void addPlace(String title, double v, double v1);

    void deletePlace(Place place);
    Set<Place> getAllPlace();

    //MessageDao
    void storeMessage(Message message);
    public List<Message> getConversation(Contact fromContact, Contact toContact);
    public List<Message> getConversationToId(long id);


    List<String> getAllMessage();

    void createNewMessageFromTo(String s, long id, long id1);


}
