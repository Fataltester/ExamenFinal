package edu.eci.cvds.ECISalud.service;

import edu.eci.cvds.ECISalud.repository.AppoinmentRepository;
import edu.eci.cvds.ECISalud.repository.MedicSpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.eci.cvds.ECISalud.model.*;

import java.time.Month;
import java.util.List;

@Service
public class MedicalSpecialityService {
    @Autowired
    private MedicSpecialityRepository medicSpecialityRepo;

    public MedicSpeciality createSpeciality(MedicSpeciality medicSpeciality){
        return medicSpecialityRepo.save(medicSpeciality);
    }

    public List<MedicSpeciality> getMedicalSpecialityByOptions(MedicSpeciality medicSpeciality){
        List<MedicSpeciality> filteredMedicSpeciality;
        String name = medicSpeciality.getName();
        String description = medicSpeciality.getDescription();
        String location = medicSpeciality.getLocation();
        String doctor = medicSpeciality.getDoctor();
        filteredMedicSpeciality = medicSpecialityRepo.findAppointmentByOptions(
                name != null ? name : ".*",
                description != null ? description : ".*",
                location != null ? location : ".*",
                doctor != null ? doctor : ".*"
        );
        return filteredMedicSpeciality;
    }

    public void deleteSpeciality(String name, String type){

    }
}
