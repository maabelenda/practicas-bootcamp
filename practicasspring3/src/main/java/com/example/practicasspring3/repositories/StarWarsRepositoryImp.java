package com.example.practicasspring3.repositories;

import com.example.practicasspring3.dtos.IngredientDTO;
import com.example.practicasspring3.dtos.StarWarsCharacterDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class StarWarsRepositoryImp implements StarWarsRepository {


    @Override
    public List<StarWarsCharacterDTO> searchCharacters(String name) {
        List<StarWarsCharacterDTO> starWarsCharacterDTOS;
        starWarsCharacterDTOS = loadDatabase();
        List<StarWarsCharacterDTO> response = null;

        if(Objects.nonNull(starWarsCharacterDTOS)){
            response = starWarsCharacterDTOS.stream()
                    .filter(starWarsCharacter -> starWarsCharacter.getName().contains(name)).collect(Collectors.toList());
        }
        return response;
    }

    private List<StarWarsCharacterDTO> loadDatabase(){
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:static/starwars.json");

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return mapObject(file);
    }

    private List<StarWarsCharacterDTO> mapObject(File file){
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<StarWarsCharacterDTO>> typeReference = new TypeReference<>(){};
        List<StarWarsCharacterDTO> priceDTOS = null;
        try {
            priceDTOS = objectMapper.readValue(file, typeReference);
        }catch (IOException e){
            e.printStackTrace();
        }

        return priceDTOS;
    }
}
