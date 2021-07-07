package com.example.practicasspring3.services;

import com.example.practicasspring3.dtos.IngredientDTO;
import com.example.practicasspring3.dtos.requests.FoodRequestDTO;
import com.example.practicasspring3.dtos.responses.CaloriesResponseDTO;
import com.example.practicasspring3.exceptions.ApiException;
import com.example.practicasspring3.repositories.CalorieRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CalorieServiceImp implements CalorieService {

    CalorieRepository calorieRepository;

    public CalorieServiceImp(CalorieRepository calorieRepository){
        this.calorieRepository = calorieRepository;
    }

    @Override
    public CaloriesResponseDTO obtainFoodCalorie(FoodRequestDTO request) {

        List<IngredientDTO> listIngredients = calorieRepository.getIngredients(request.getIngredients()
                .stream().map(s -> s.getName()).collect(Collectors.toList()));

        if(Objects.isNull(listIngredients)) {
            return new CaloriesResponseDTO(0);
        }

        return new CaloriesResponseDTO(listIngredients.stream()
                .mapToInt(ingredient -> ingredient.getCalories()).sum());
    }

    @Override
    public List<IngredientDTO> ingredientsCalorie(FoodRequestDTO request) {
        List<IngredientDTO> listIngredients = calorieRepository.getIngredients(request.getIngredients()
                .stream().map(s -> s.getName()).collect(Collectors.toList()));

        if(Objects.isNull(listIngredients)) {
            return new ArrayList<>();
        }
        return listIngredients;
    }

    @Override
    public IngredientDTO obtainMaxCalorieIngredient(FoodRequestDTO request) {
        List<IngredientDTO> listIngredients = calorieRepository.getIngredients(request.getIngredients()
                .stream().map(s -> s.getName()).collect(Collectors.toList()));

        if(Objects.isNull(listIngredients)) {
            Optional<IngredientDTO> item = listIngredients.stream()
                    .max((o1, o2) -> o1.getCalories() - o2.getCalories());
            if(item.isPresent()) {
                return item.get();
            }
        }
        Map<String, String> errors = new HashMap<>();
        throw new ApiException(404, "not found", errors);
    }
}
