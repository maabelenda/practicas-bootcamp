package meli.bootcamp.practicaspring5.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentResponseDTO {

    private String name;
    private Integer id;

}
