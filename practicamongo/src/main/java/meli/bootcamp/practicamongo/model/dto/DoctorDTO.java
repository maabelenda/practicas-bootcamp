package meli.bootcamp.practicamongo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {

    private String firstName;

    private String lastName;

    private String specialty;

}
