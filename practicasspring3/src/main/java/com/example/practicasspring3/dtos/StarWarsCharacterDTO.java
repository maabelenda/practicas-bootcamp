package com.example.practicasspring3.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StarWarsCharacterDTO {
    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;

}
