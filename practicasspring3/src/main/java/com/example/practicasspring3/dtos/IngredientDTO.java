package com.example.practicasspring3.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDTO {

    private String name;
    private Integer calories;

}
