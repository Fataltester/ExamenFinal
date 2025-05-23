package edu.eci.cvds.ECISalud.model;

import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
public class Appoinment {
    private String name;
    private String id;
    private String email;
    private Integer numberDay;
    private Month month;
    private Integer year;
    private String selectedSpeciality;
    private static List<String> state = new ArrayList<>();
    private String selectedState;
    static {
        state.addAll(List.of("Cancelada","Confirmada","Completada"));
    }

}
