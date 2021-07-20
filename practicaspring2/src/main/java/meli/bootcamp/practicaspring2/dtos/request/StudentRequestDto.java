package meli.bootcamp.practicaspring2.dtos.request;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;

@Data
@Validated
public class StudentRequestDto{


    @NotBlank(message = "El nombre del alumno no puede estar vacío.")
    //@NotNull(message = "El nombre del alumno no puede estar vacío.")
    @Pattern(regexp="^[A-Z].*$", message="El nombre del alumno comenzar con mayúscula.")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    private String name;

    @NotEmpty(message = "La lista no puede ser vacía.")
    private ArrayList<@Valid SubjectDto> subjects;
}
