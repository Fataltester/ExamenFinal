package edu.eci.cvds.ECISalud.repository;
import edu.eci.cvds.ECISalud.model.Appoinment;
import edu.eci.cvds.ECISalud.model.MedicSpeciality;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.List;

@Repository
public interface MedicSpecialityRepository extends  MongoRepository<MedicSpeciality,String> {
    MedicSpeciality findByType(String type);

    @Query("{ " +
            "'name': { $gte: ?0 }, " +
            "'description': { $regex: ?1, $options: 'i' }, " +
            "'location': { $regex: ?2, $options: 'i' }, " +
            "'doctor': { $regex: ?2, $options: 'i' }, "+
            "}")
    List<MedicSpeciality> findAppointmentByOptions(String name, String description, String location, String doctor);

}


