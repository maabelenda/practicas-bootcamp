package com.example.practicasspring3.services;

import com.example.practicasspring3.dtos.StarWarsCharacterDTO;
import com.example.practicasspring3.dtos.responses.StarWarsCharacterNameResponseDTO;
import com.example.practicasspring3.repositories.CalorieRepository;
import com.example.practicasspring3.repositories.StarWarsRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class StarWarsServiceImp implements StarWarsService{

    StarWarsRepository starWarsRepository;

    public StarWarsServiceImp(StarWarsRepository starWarsRepository){
        this.starWarsRepository = starWarsRepository;
    }

    @Override
    public List<StarWarsCharacterNameResponseDTO> searchCharacters(String name) {

        List<StarWarsCharacterDTO> list = starWarsRepository.searchCharacters(name);

        if(Objects.isNull(list)) {
            return new ArrayList<>();
        }

        return list.stream()
                .map(starWarsCharacter -> new StarWarsCharacterNameResponseDTO(starWarsCharacter.getName()))
                .collect(Collectors.toList());
    }
}
