package allProject.dao;

import allProject.entity.Contact;
import allProject.entity.Message;

import java.util.List;

/**
 * Created by Aleksandr on 26.03.2015.
 */
public interface MessageDao {
    void storeMessage(Message message);
    public List<Message> getConversation(Contact fromContact, Contact toContact);

    List<Message> getConversationToId(long id);


    List<String> getAllMessages();

    void createNewMessageFromTo(String s, long id, long id1);
}
