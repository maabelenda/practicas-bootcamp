package meli.bootcamp.practicaspring2.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentResponseDto{

    private String name;
    private String message;
    private Double average;
}
