package com.example.practicasspring3.repositories;

import com.example.practicasspring3.dtos.StarWarsCharacterDTO;

import java.util.List;

public interface StarWarsRepository {

    List<StarWarsCharacterDTO> searchCharacters(String name);
}
