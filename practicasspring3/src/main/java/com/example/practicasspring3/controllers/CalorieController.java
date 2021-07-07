package com.example.practicasspring3.controllers;

import com.example.practicasspring3.dtos.IngredientDTO;
import com.example.practicasspring3.dtos.requests.FoodRequestDTO;
import com.example.practicasspring3.dtos.responses.CaloriesResponseDTO;
import com.example.practicasspring3.repositories.CalorieRepository;
import com.example.practicasspring3.services.CalorieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/calories")
@Validated
public class CalorieController {

    CalorieService calorieService;

    public CalorieController(CalorieService calorieService){
        this.calorieService = calorieService;
    }


    @PostMapping("/totalCalorie")
    public ResponseEntity<CaloriesResponseDTO> totalCalorie(@Valid @RequestBody FoodRequestDTO request){

        return new ResponseEntity<>(calorieService.obtainFoodCalorie(request), HttpStatus.OK);
    }

    @PostMapping("/ingredientsCalories")
    public ResponseEntity<List<IngredientDTO>> ingredientsCalories(@Valid @RequestBody FoodRequestDTO request){

        return new ResponseEntity<>(calorieService.ingredientsCalorie(request), HttpStatus.OK);
    }

    @PostMapping("/maxCalorieIngredient")
    public ResponseEntity<IngredientDTO> obtainMaxCalorieIngredient(@Valid @RequestBody FoodRequestDTO request){

        return new ResponseEntity<>(calorieService.obtainMaxCalorieIngredient(request), HttpStatus.OK);
    }
}
