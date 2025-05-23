package edu.eci.cvds.ECISalud.repository;
import edu.eci.cvds.ECISalud.model.Appoinment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.List;

@Repository
public interface AppoinmentRepository extends MongoRepository<Appoinment, String> {

    @Query("{ " +
            "'name': { $gte: ?0 }, " +
            "'id': { $regex: ?1, $options: 'i' }, " +
            "'email': { $regex: ?2, $options: 'i' }, " +
            "'numberDay': { $gte: ?3 } " +
            "'month': { $gte: ?4 } " +
            "'year': { $gte: ?5 }" +
            "}")
    List<Appoinment> findAppointmentByOptions(String name, String id, String email, Integer numberDay, Month month, Integer year);

    void updateState()
}
