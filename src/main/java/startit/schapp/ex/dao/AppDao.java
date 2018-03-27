package startit.schapp.ex.dao;

import startit.schapp.ex.model.Appointment;
import startit.schapp.ex.model.Room;

import java.sql.Timestamp;
import java.util.List;

//interface holding methods to be implemented
public interface AppDao {
    boolean slotTaken(Timestamp date) throws Exception;
    List<Appointment> listAllApps() throws Exception;
    Appointment getAppointment(Integer id) throws Exception;
    List<Appointment> listAppsByUser(String requester) throws Exception;
    Appointment newAppointment(String requester, Room room, Timestamp date) throws Exception;
    Appointment modifyApp(Integer id, Room room, Timestamp date) throws Exception;
    Appointment removeApp(Integer id) throws Exception;
}
