package startit.schapp.ex.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import startit.schapp.ex.model.Appointment;
import startit.schapp.ex.model.Room;


@RestController//spring REST annotation
public class WebController {

    @Autowired
    private ObjectService service;

    @Autowired
    Appointment app;

    @Autowired
    Room room;

    //on this page all appointments will be shown
    @RequestMapping(value = "/appointments", method = RequestMethod.GET)
    public String allAppointments(){
        return service.getAllAppointments();
    }

    //simple method that will list all avaialble rooms on a dedicated page
    @RequestMapping(value="/rooms", method = RequestMethod.GET)
    public String allRooms() {return service.getAllRooms();}

    //show a specific appointment (pentru asta a fost facuta toata bucata aia dubioasa din ObjectService)
    @RequestMapping(value = "/appointment", method = RequestMethod.GET)
    public String yourAppointment(@RequestParam("user") String user,
                                  @RequestParam("appdate") String appdate){
        try {
            return service.appointmentWithRoomName(user,appdate);
        } catch (Exception e) {return e.toString();}
    }
}
