package meli.bootcamp.practicaspring2.dtos.request;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Validated
public class HouseRequestDto {

    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede estar vacio")
    private String name;

    @NotNull(message = "La direccion no puede ser nula")
    @NotBlank(message = "La direccion no puede estar vacia")
    private String address;

    @NotEmpty(message = "El array no puede estar vacio")
    private List<RoomRequestDto> rooms;
}
