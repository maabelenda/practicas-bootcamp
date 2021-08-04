package meli.bootcamp.practicaspring5.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateStudentDTO {
    private String name;
    private Integer id;
}
