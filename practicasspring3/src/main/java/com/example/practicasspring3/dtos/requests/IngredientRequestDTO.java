package com.example.practicasspring3.dtos.requests;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Validated
public class IngredientRequestDTO {

    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede estar vacio")
    private String name;

    @NotNull(message = "El peso no puede ser nulo")
    private Double weight;

}
