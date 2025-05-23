package edu.eci.cvds.ECISalud.service;
import edu.eci.cvds.ECISalud.repository.AppoinmentRepository;
import edu.eci.cvds.ECISalud.repository.MedicSpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.eci.cvds.ECISalud.model.*;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppoinmentRepository appoinmentRepo;
    @Autowired
    private MedicSpecialityRepository medicSpecialityRepo;

    public Appoinment createAppointment(Appoinment appoinment){
        MedicSpeciality medicSpeciality = medicSpecialityRepo.findByType(appoinment.getSelectedSpeciality());
        medicSpeciality.addAppointment(appoinment.getId());
        medicSpecialityRepo.save(medicSpeciality);
        return appoinmentRepo.save(appoinment);
    }

    public List<Appoinment> getAllAppointments(){
        return appoinmentRepo.findAll();
    }

    public List<Appoinment> getAppointmentByOptions(Appoinment appoinment){
        List<Appoinment> filteredAppointments;
        String name = appoinment.getName();
        String id = appoinment.getId();
        String email = appoinment.getEmail();
        Integer numberDay = appoinment.getNumberDay();
        Month month = appoinment.getMonth();
        Integer year = appoinment.getYear();
        filteredAppointments = appoinmentRepo.findAppointmentByOptions(
                name != null ? name : ".*",
                id != null ? id : ".*",
                email != null ? email : ".*",
                numberDay,
                month,
                year
        );
        return filteredAppointments;
    }

    public void updateState(Appoinment appoinment, String state){
        Optional<Appoinment> requested = appoinmentRepo.findById(appoinment.getId());
        if(requested.isPresent()){
            Appoinment requestedAp = requested.get();
            requestedAp.setSelectedState(state);
            appoinmentRepo.save(requestedAp);
        }

    }


    public void deleteAppointment(String id){
        appoinmentRepo.deleteById(id);
    }
}
