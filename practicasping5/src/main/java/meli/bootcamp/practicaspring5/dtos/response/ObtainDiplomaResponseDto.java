package meli.bootcamp.practicaspring5.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ObtainDiplomaResponseDto {

    private String name;
    private String message;
    private Double average;
}
