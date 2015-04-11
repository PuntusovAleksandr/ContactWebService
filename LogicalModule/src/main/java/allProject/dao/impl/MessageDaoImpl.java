package allProject.dao.impl;

import allProject.dao.MessageDao;
import allProject.entity.Contact;
import allProject.entity.Message;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;
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
    public List<Message> getConversation(Contact fromContact, Contact toContact) {
        long fromId = fromContact.getId();
        long toId = toContact.getId();
        String stringQuery = "from Message m where (m.fromId = :fromId and m.toId = :toId) or (m.toId = :toId and m.fromId = :fromId)";
        return sessionFactory.getCurrentSession().createQuery(stringQuery).setParameter("fromId", fromId).setParameter("toId", toId).list();
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<Message> getConversationToId(long id) {
        String zzz = "from Message m where  m.fromId = :id";
        List<Message> messageList = sessionFactory.getCurrentSession().createQuery(zzz).setParameter("id", id).list();
        if  ( messageList==null)return null;
        return messageList;
    }

    @Override
    @Transactional
    public List<String> getAllMessages() {
        return sessionFactory.getCurrentSession().createQuery("from Message").list();
    }

    @Override
    @Transactional
    public void createNewMessageFromTo(String s, long id, long id1) {
        Message message = new Message();
        message.setContent(s);;
        message.setFromId(id);
        message.setToId(id1);
        sessionFactory.getCurrentSession().saveOrUpdate(message );
    }


}
