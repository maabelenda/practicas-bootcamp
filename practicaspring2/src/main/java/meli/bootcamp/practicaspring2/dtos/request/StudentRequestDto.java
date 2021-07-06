package meli.bootcamp.practicaspring2.dtos.request;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.util.ArrayList;

@Data
@Validated
public class StudentRequestDto{


    @NotBlank(message = "El nombre esta vacio")
    @NotNull(message = "El nombre esta nulo")
    private String name;

    @NotEmpty(message = "Esta coleccion esta vacio")
    private ArrayList<SubjectDto> subjects;
}
