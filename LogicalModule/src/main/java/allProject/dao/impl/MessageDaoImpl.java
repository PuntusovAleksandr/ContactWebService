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
        String stringQuery = "from Message m where m.fromId = :fromId and m.toId = :toId";
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


}
