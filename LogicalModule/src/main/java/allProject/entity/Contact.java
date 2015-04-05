package allProject.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Aleksandr on 25.03.2015.
 */
@Entity
@Table(name = "contact")
public class Contact implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="CONTACT_HOBBIES",
            joinColumns={@JoinColumn(name = "CONTACT_ID")}
            , inverseJoinColumns={@JoinColumn(name="HOBBY_ID")})
    private Set<Hobby> hobbies;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "CONTACT_PLACES",
            joinColumns = {@JoinColumn(name= "CONTACT_ID")}
            , inverseJoinColumns = {@JoinColumn(name = "PLACE_ID")})
    private Set<Place> places;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "LIST_FRIENDS",
            joinColumns = {@JoinColumn(name= "CONTACT_ID_ONE")}
            , inverseJoinColumns = {@JoinColumn(name = "CONTACT_ID_TWO")})
    private Set<Contact> friends;

    @ManyToMany(mappedBy = "friends")
    private Set<Contact> contactsFriends;


    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "CONTACT_ID")
    @JoinTable(name = "CONTACT_MESSAGE",
            joinColumns = {@JoinColumn(name= "CONTACT_ID")}
            , inverseJoinColumns = {@JoinColumn(name = "MESSAGE_ID")})
    private List<Message> messages;





    public Contact() {    }
    public Contact(String firstName) {
        this.firstName = firstName;
    }

    public Contact(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public List<Message> getMessages() {
        if (messages == null) messages = new ArrayList<Message>();
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Set<Contact> getContactsFriends() {
        if (contactsFriends==null) contactsFriends = new HashSet<Contact>();
        return contactsFriends;
    }

    public void setContactsFriends(Set<Contact> contactsFriends) {
        this.contactsFriends = contactsFriends;
    }

    public Set<Contact> getFriends() {
        if (friends==null) friends =  new HashSet<Contact>();
        return friends;
    }
    public void setFriends(Set<Contact> friends) {
        this.friends = friends;
    }

    public Set<Place> getPlaces() {
        if (places == null) places = new HashSet<Place>();
        return places;
    }
    public void setPlaces(Set<Place> places) {
        this.places = places;
    }
    public Set<Hobby> getHobbies() {
        if (hobbies==null) hobbies= new HashSet<Hobby>();
        return hobbies;
    }
    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (id != contact.id) return false;
        if (birthDate != null ? !birthDate.equals(contact.birthDate) : contact.birthDate != null) return false;
        if (!firstName.equals(contact.firstName)) return false;
        if (lastName != null ? !lastName.equals(contact.lastName) : contact.lastName != null) return false;

        return true;
    }
    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + firstName.hashCode();
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}'+"\n";
    }
}
