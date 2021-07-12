package meli.bootcamp.practicaspring4.dtos.requests;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.util.List;

@Data
@Validated
public class LinkRequestDTO {

    @NotNull(message = "La url no puede ser nula")
    @NotBlank(message = "La url no puede estar vacia")
    @Pattern(regexp = "[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)",
            message = "La url ingresada no es valida")
    private String url;

    @Size(min = 8, max = 16, message = "La password debe ser mayor a 7 y menor a 17")
    private String password;

}
