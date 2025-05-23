package edu.eci.cvds.ECISalud.controller;
import edu.eci.cvds.ECISalud.model.Appoinment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.eci.cvds.ECISalud.service.*;
import edu.eci.cvds.ECISalud.service.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentServ;

    @PostMapping("/newAppointment")
    public Appoinment createAppointment(@RequestBody Appoinment appoinment){
        return appointmentServ.createAppointment(appoinment);
    }

    @GetMapping("/find/options")
    public List<Appoinment> findAppointmentByOptions(@RequestBody Appoinment appoinment){
        return appointmentServ.getAppointmentByOptions(appoinment);
    }

    @PutMapping("update/state")
    public void updateStateApointment(@RequestBody Appoinment appoinment,String newState){
        appointmentServ.updateState(appoinment,newState);
    }

    @DeleteMapping("/update")
    public void deleteAppointment(@RequestBody Appoinment appoinment){
        appointmentServ.deleteAppointment(appoinment.getId());
    }


}
