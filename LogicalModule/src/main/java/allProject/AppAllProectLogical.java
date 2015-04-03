package allProject;

import allProject.dao.ContactDao;
import allProject.dao.HobbyDao;
import allProject.dao.MessageDao;
import allProject.dao.PlaceDao;
import allProject.entity.Contact;
import allProject.entity.Hobby;
import allProject.entity.Place;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Aleksandr on 03.04.2015.
 */
public class AppAllProectLogical {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("logic-config.xml");
        ContactDao contactDao = context.getBean(ContactDao.class);
        HobbyDao hobbyDao = context.getBean(HobbyDao.class);
        PlaceDao placeDao = context.getBean(PlaceDao.class);
        MessageDao messageDao = context.getBean(MessageDao.class);

        Contact contactAleks = new Contact();
        contactAleks.setFirstName("Aleks");
        contactAleks.setLastName("Pro");
        Contact contactSerg = new Contact();
        contactSerg.setFirstName("Serg");
        contactSerg.setLastName("Serg");
        Contact contactMaks = new Contact();
        contactMaks.setFirstName("Maks");
        contactMaks.setLastName("Maks");

        contactDao.addContact(contactAleks);
        System.out.println(contactDao.getAllContact());
        contactDao.addContact(contactMaks);
        contactDao.addContact(contactSerg);
        contactDao.addContact(new Contact("Rishard"));

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println(contactDao.getAllContact());

        System.out.println(hobbyDao.getAllHobbies());
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        hobbyDao.addHobby(new Hobby("Fishing"));
        hobbyDao.addHobby(new Hobby("Footbool"));
        System.out.println(hobbyDao.getAllHobbies());
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        placeDao.addPlace(new Place("Odess"));
        placeDao.addPlace(new Place("Lvov"));
        System.out.println(placeDao.getAllPlace());
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");


        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");


//        Message message = new Message();
//        message.setContactId(contactAleks.getId());
//        message.setContent("Vasilok");
//        messageDao.storeMessage(message);
//        messageDao.storeMessage(new Message(1, "прЫвет Aleks"));
//
//        System.out.println(messageDao.getConversation(contactAleks));
//        System.out.println(messageDao.getConversation(contactMaks));


    }
}
