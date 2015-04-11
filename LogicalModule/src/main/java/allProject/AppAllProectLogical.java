package allProject;

import allProject.dao.ContactDao;
import allProject.dao.HobbyDao;
import allProject.dao.MessageDao;
import allProject.dao.PlaceDao;
import allProject.entity.Contact;
import allProject.entity.Hobby;
import allProject.entity.Message;
import allProject.service.ContactService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Created by Aleksandr on 03.04.2015.
 */
public class AppAllProectLogical {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("logic-config.xml");
        ContactService contactService = context.getBean(ContactService.class);
        ContactDao contactDao = context.getBean(ContactDao.class);
        HobbyDao hobbyDao = context.getBean(HobbyDao.class);
        PlaceDao placeDao = context.getBean(PlaceDao.class);
        MessageDao messageDao = context.getBean(MessageDao.class);


        System.out.println("xxxxxxxxxxxxxxxxxxxallContactxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println(contactService.getAllContact());
        System.out.println("xxxxxxxxxxxxxxxxxxxagetContacttxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println(contactService.getContact(1));
        contactService.addContact(new Contact("AAAAAAAAAAAAAAA"));
        Hobby as = new Hobby("PPPPPPPPPPPPPPP");
        contactService.createHobby(as);


        Contact aaaa = new Contact("BBBBBBBBBBBBB");
        contactService.addContact(aaaa);
        contactService.addHobbyByContact(aaaa,as );
        Contact aleks = new Contact("Aleks");
        Contact bora = new Contact("Bora");

        System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");

        contactService.createContact("Sasha", "Stukalo", new Date(86, 1, 1));
        contactService.addHobby("football", "favourite team is Dnipro");
        contactService.addPlace("Lviv", 0.21, 0.15);
        Contact contact = new Contact("Jane", "Patric", new Date(23, 1, 4));
        Hobby hobby = new Hobby("movies", "Detective");
        contactService.addPlace("Paris", 0.2, 0.3);
        contactService.addHobbyByContact(contact, hobby);
        System.out.println(contactService.getHobbiesFromContact(contact));

        System.out.println("]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]");
        contactService.addFriendship(aleks, bora);

//        System.out.println(contactService.getAllFriendsFromContact(aleks));
        Hobby grip = new Hobby("rt3gtb35");
        contactService.addHobbyByContact(bora, grip);

        System.out.println(contactService.getHobbiesFromContact(bora));
        System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
        System.out.println(contactService.getAllHobbies());

        System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
        Contact aprAleks = new Contact("Aeks", "AAAAAAAAA", new Date(2000, 12, 31));
        contactService.addContact(aprAleks);
        aprAleks.getMessages().add(new Message(1, 2,  "Hi Contact with Id= 1"));
        contactService.storeMessage(new Message(aprAleks.getId(), aaaa.getId(), "Hi  Aleks! "));
        System.out.println(contactService.getContact(aprAleks.getId()));
        Message message1 = new Message();
        message1.setContent("Hi Contact with Id= 1");

        contactService.storeMessage(message1);
        List<Message> messageList = (contactService.getContact(aprAleks.getId()).getMessages());

//        System.out.println(contactService.getConversation(aprAleks));
        System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        System.out.println(contactService.getConversation(aprAleks, aaaa));
        System.out.println(contactService.getConversationToId(aprAleks.getId()));
        System.out.println("_________________________________________________________________");

        aprAleks.getMessages().add(new Message(aprAleks.getId(), aaaa.getId(), "Hi anyone"));
        aaaa.getMessages().add(new Message(aaaa.getId(), aprAleks.getId(), "Hi Aleks"));
        System.out.println(contactService.getConversationToId(aprAleks.getId()));

        System.out.println(contactService.getAllMessage());
        System.out.println(contactService.getAllContact());
        System.out.println("=======================================================================");
        contactService.createNewMessageFromTo(" Привет незнакомец ", aleks.getId(), aaaa.getId());
        contactService.createNewMessageFromTo(" О, здорово! ", aaaa.getId(), aprAleks.getId());
        System.out.println(contactService.getAllMessage());
        System.out.println(contactService.getConversationToId(aaaa.getId()));


    }


}
