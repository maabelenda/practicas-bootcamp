package meli.bootcamp.practicamongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    private String firstName;

    private String lastName;

    private String specialty;

}
