package meli.bootcamp.practicaspring5.dtos.request;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

@Data
@Validated
public class SubjectDto {

    @NotBlank(message = "El nombre de la materia no puede estar vacío.")
    @Pattern(regexp="^[A-Z].*$", message="El nombre de la materia debe comenzar con mayúscula.")
    @Size(max = 30, message = "LLa longitud del nombre no puede superar los 30 caracteres.")
    private String name;

    @DecimalMax(value = "10.0", message = "La máxima nota es 10.0.")
    @DecimalMin( value = "0.0", message = "La mínima nota es 0.0.")
    @NotNull(message = "La nota no puede estar vacía.")
    private Double score;
}
