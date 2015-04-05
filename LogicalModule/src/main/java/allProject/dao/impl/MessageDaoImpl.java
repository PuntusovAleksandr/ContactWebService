package allProject.dao.impl;

import allProject.dao.MessageDao;
import allProject.entity.Contact;
import allProject.entity.Message;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Aleksandr on 26.03.2015.
 */
@Repository
public class MessageDaoImpl implements MessageDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void storeMessage(Message message) {
        sessionFactory.getCurrentSession().saveOrUpdate(message);
    }

    @Override
    @Transactional
    public List<Message> getConversation(Contact contact) {
        return getConversationToId(contact.getId());
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<Message> getConversationToId(long id) {
        String zzz = "from Message m where  m.contactId = :"+id;
        List<Message> messageList = sessionFactory.getCurrentSession().createQuery(zzz).list();
        if  ( messageList==null)return null;
        return messageList;
    }


}
