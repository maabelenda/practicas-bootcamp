package com.example.practicasspring3.services;

import com.example.practicasspring3.dtos.StarWarsCharacterDTO;
import com.example.practicasspring3.dtos.responses.StarWarsCharacterNameResponseDTO;

import java.util.List;

public interface StarWarsService {

    public List<StarWarsCharacterNameResponseDTO> searchCharacters(String name);
}
