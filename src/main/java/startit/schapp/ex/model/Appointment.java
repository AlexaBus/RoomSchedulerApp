package startit.schapp.ex.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;


//this class will create appointment objects based on the appointments table in the db
@Component//Spring bean
@Entity //JPA mandatory annotation that marks a class that needs to be mapped to a table
//tie class to the appointments table
@Table(name = "appointments", uniqueConstraints = {
        @UniqueConstraint(columnNames = "appid")})
public class Appointment {

    @Id//JPA mandatory annotation which declares a property as the id
    @Column(name="appid")
    private Integer id;

    //other columns in the db mapped to class properties
    @Column(name="apprequester")
    private String requester;

    @Column(name = "approomid")
    private Integer roomid;

    @Column(name="appdate")
    private Timestamp date;

    //default and parametrized constructor
    Appointment() {
    }

    public Appointment(Integer id, String requester, Integer roomid, Timestamp date) {
        this.id=id;
        this.requester = requester;
        this.roomid = roomid;
        this.date = date;
    }

    //standard setters and getters
    private Integer getId() {
        return id;
    }

    private String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public Integer getRoomId() {
        return roomid;
    }

    public void setRoom(Integer roomid) {
        this.roomid = roomid;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    //object to string custom method
    //might not be needed as i plan to put together the object as a string outside the class. will see
    public String toString() {
        return "Appntmnt ID: " + getId() + ";\nrequester: " + getRequester() +
                ";\nroom: " + getRoomId()+
                ";\ndate " + getDate() +"\n";
    }
}
