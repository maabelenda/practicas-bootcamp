package com.example.practicasspring3.dtos.requests;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Validated
public class FoodRequestDTO {

    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede estar vacio")
    private String name;

    @NotNull(message = "La lista de ingredientes no puede ser nula")
    private List<IngredientRequestDTO> ingredients;
}
