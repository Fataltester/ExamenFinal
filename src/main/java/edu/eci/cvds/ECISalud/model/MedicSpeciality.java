package edu.eci.cvds.ECISalud.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class MedicSpeciality {
    private String name;
    private String description;
    private static List<String> type = new ArrayList<>();
    private String location;
    private String doctor;
    private List<String> appoinments = new ArrayList<>();

    static {
        type.addAll(List.of("medicina general","psicología","ortopedia","odontologia"));
    }

    public void addAppointment(String id){
        appoinments.add(id);
    }
}