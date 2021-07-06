package meli.bootcamp.practicaspring2.dtos.request;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@Validated
public class RoomRequestDto {

    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede estar vacio")
    private String name;

    @NotNull(message = "El ancho no puede ser nulo")
    private Double wide;

    @NotNull(message = "El largo no puede ser nulo")
    private Double longitude;

}
