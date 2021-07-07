package com.example.practicasspring3.services;

import com.example.practicasspring3.dtos.IngredientDTO;
import com.example.practicasspring3.dtos.requests.FoodRequestDTO;
import com.example.practicasspring3.dtos.responses.CaloriesResponseDTO;

import java.util.List;

public interface CalorieService {

    CaloriesResponseDTO obtainFoodCalorie(FoodRequestDTO request);

    List<IngredientDTO> ingredientsCalorie(FoodRequestDTO request);

    IngredientDTO obtainMaxCalorieIngredient(FoodRequestDTO request);

}
