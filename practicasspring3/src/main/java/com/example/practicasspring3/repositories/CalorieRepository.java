package com.example.practicasspring3.repositories;

import com.example.practicasspring3.dtos.IngredientDTO;

import java.util.List;

public interface CalorieRepository {

    List<IngredientDTO> getIngredients(List<String> listIngredients);

}
