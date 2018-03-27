package startit.schapp.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import startit.schapp.ex.dao.AppDao;
import startit.schapp.ex.dao.RoomDao;
import startit.schapp.ex.model.Appointment;
import startit.schapp.ex.model.Room;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

//class that handles puting together appointment information and room information (room name)
@Service//spring bean
public class ObjectService {

    @Autowired
    private AppDao appointmentDao;

    @Autowired
    private RoomDao roomDao;

    @Autowired
    private Room room;

    @Autowired
    private Appointment appointment;


    private List<Appointment> apps;


    public String getAllAppointments() {
        try {
            return appointmentDao.listAllApps().toString();
        } catch (Exception e) {return e.toString();}
    }

    public String getAllRooms() {
        try {
            return roomDao.listAllRooms().toString();
        } catch (Exception e) {return e.toString();}
    }


    //de aici mi se pare ca m-am complicat.
    //metoda asta intoarce o rezervare pe baza userului si a datei(inclusiv ora)
    public Appointment getAppointmentByUserAndDate(String requester, String appdate) throws Exception {
        //de aici pana
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parsedDate = dateFormat.parse(appdate);
        Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
        //aici transform stringul pus in aplicatie intr-un timestamp pe baza caruia sa gasesc rezervarea exacta

        //pun toate rezervarile pe baza userului
        apps = appointmentDao.listAppsByUser(requester);
        //si cu un stream il gasesc pe cel care-mi trebuie pe baza timestampului de mai sus
        return apps.stream().filter(appointment1 -> appointment1.getDate().equals(timestamp)).findFirst().get();
    }

    //asta intoarce numele camerei pe baza appointmentului de mai sus
    private String getRoomName(String requester, String appdate) {
        try {
            appointment = getAppointmentByUserAndDate(requester,appdate);
            room = roomDao.getRoom(appointment.getRoomId());
            return room.getName();
        } catch (Exception e) {return e.toString();}
    }

    //si fac tot ce e mai sus doar ca sa pun intr-un string numele camerei si sa nu afisez id-ul
    //trebuie sa se paote face mai usor
    public String appointmentWithRoomName(String requester, String appdate) throws Exception {
        return "Hello " + requester +". Room " + getRoomName(requester,appdate)+
                " is reserved for you on " + getAppointmentByUserAndDate(requester,appdate).getDate();
        }
}
