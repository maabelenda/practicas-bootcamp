package meli.bootcamp.practicaspring2.dtos.request;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

@Data
@Validated
public class SubjectDto {

    @NotBlank(message = "El nombre esta vacio")
    @NotNull(message = "El nombre esta nulo")
    private String name;

    @DecimalMax(value = "10.0", message = "La nota no puede ser mayor a 10")
    @DecimalMin( value = "0.0", message = "La nota no puede ser menor a cero")
    @NotNull(message = "La nota no puede ser nula")
    private Double score;
}
