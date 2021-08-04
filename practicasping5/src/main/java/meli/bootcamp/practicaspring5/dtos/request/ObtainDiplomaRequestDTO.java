package meli.bootcamp.practicaspring5.dtos.request;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
@Validated
public class ObtainDiplomaRequestDTO {


    @NotBlank(message = "El nombre del alumno no puede estar vacío.")
    @Pattern(regexp="^[A-Z].*$", message="El nombre del alumno comenzar con mayúscula.")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    private String name;

    @NotEmpty(message = "La lista no puede ser vacía.")
    private ArrayList<@Valid SubjectDto> subjects;
}
