package meli.bootcamp.practicaspring5.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateStudentDTO {
    private String name;
}
