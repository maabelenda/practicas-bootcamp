package com.example.practicasspring3.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.example.practicasspring3.dtos.IngredientDTO;
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
public class CalorieRepositoryImp implements CalorieRepository {


    @Override
    public List<IngredientDTO> getIngredients(List<String> listIngredients) {
        List<IngredientDTO> ingredientDTOs;
        ingredientDTOs = loadDatabase();
        List<IngredientDTO> response = null;

        if(Objects.nonNull(ingredientDTOs)){
            response = ingredientDTOs.stream()
                    .filter(ingredient -> listIngredients.contains(ingredient.getName())).collect(Collectors.toList());
        }
        return response;
    }

    private List<IngredientDTO> loadDatabase(){
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:static/food.json");

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return mapObject(file);
    }

    private List<IngredientDTO> mapObject(File file){
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredientDTO>> typeReference = new TypeReference<>(){};
        List<IngredientDTO> priceDTOS = null;
        try {
            priceDTOS = objectMapper.readValue(file, typeReference);
        }catch (IOException e){
            e.printStackTrace();
        }

        return priceDTOS;
    }

}
