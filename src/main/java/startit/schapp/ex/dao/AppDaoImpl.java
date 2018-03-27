package startit.schapp.ex.dao;

import org.springframework.stereotype.Repository;
import startit.schapp.ex.model.Appointment;
import startit.schapp.ex.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.List;

@Repository//spring bean adn
public class AppDaoImpl implements AppDao {

    //Spring will handle object instantiation
    @Autowired
    private Appointment appointment;

    //this will handle the persistence to the db using the entitymanagerfactory bean in spring.xml
    @PersistenceContext
    private EntityManager em;

    //for security reasons i store the queries in strings that will be used in methods
    private final String selectAppById = "from Appointment a where a.id=:id";
    private final String selectAllAppsByDate = "from Appointment a where day(a.date)=:date";
    private final String selectAllAppsByUser = "from Appointment a where a.requester=:requester";
    private final String selectAllApps = "from Appointment";
    private final String selectAllTimestampsFromADay =
            "select a.appdate from Appointment a where day(a.date)=:date";

    //annotation that marks the method as a spring transaction that will use the JPA transaction manager declared as bean in spring.xml
    @Transactional
    //check if a time slot is free or not.
    public boolean slotTaken(Timestamp date) throws Exception {

        List dates = em.createQuery(selectAllTimestampsFromADay)
                                .setParameter("date", date)
                                .getResultList();

        return dates.indexOf(date) != -1;
    }

    @Transactional
    //get all appointments in the db in a list
    public List<Appointment> listAllApps() throws Exception{
        return em.createQuery(selectAllApps,Appointment.class)
                .getResultList();
    }

    @Transactional
    //if the user knows the id of his appointment he can use it to see its details. impractical
    public Appointment getAppointment(Integer id) throws Exception{
        appointment = em.createQuery(selectAppById, Appointment.class)
                .setParameter("id",id)
                .getSingleResult();
        return appointment;
    }

    @Transactional
    //this retrieves all appointments by user id.
    // the plan is that when the user logs in, in the background, the web interface will send the
    //user id here and the home page would show the list by deafult
    public List<Appointment> listAppsByUser(String requester) throws Exception{
        return em.createQuery(selectAllAppsByUser,Appointment.class)
                                   .setParameter("requester",requester)
                                   .getResultList();
    }

    //add new appointment. also on the home page the ser will have a button for new appointment. to be implemented
    public Appointment newAppointment(String requester, Room room, Timestamp date) throws Exception {
        return null;
    }

    //modify appointment will be mapped on the appointment id(or another element) on the home page and when
    //clicked it will open a new page where the user will be able to change the reservation
    public Appointment modifyApp(Integer id, Room room, Timestamp date) throws Exception {
        return null;
    }

    //on the home page, on the line for each appointment, there will be a button that will have this method mapped to it
    //and the user will be able to delete that appointment
    public Appointment removeApp(Integer id) throws Exception {
        return null;
    }

}
