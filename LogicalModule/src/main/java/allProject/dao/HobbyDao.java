package allProject.dao;

import allProject.entity.Contact;
import allProject.entity.Hobby;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by Aleksandr on 25.03.2015.
 */
public interface HobbyDao {

    void addHobby(Hobby hobby);
    Set<Hobby> getAllHobbies();
    void deleteHobby(Hobby hobby);

    @Transactional
    Set<Contact> getAllContactsWithHobby(Hobby hobby);
}
