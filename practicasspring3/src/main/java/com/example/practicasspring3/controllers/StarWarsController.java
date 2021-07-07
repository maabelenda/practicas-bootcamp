package com.example.practicasspring3.controllers;

import com.example.practicasspring3.dtos.responses.StarWarsCharacterNameResponseDTO;
import com.example.practicasspring3.services.StarWarsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/starWars")
@Validated
public class StarWarsController {

    StarWarsService starWarsService;

    public StarWarsController(StarWarsService starWarsService){
        this.starWarsService = starWarsService;
    }

    @GetMapping("/searchCharacter/")
    public ResponseEntity<List<StarWarsCharacterNameResponseDTO>> searchCharacter(@Valid @NotNull @RequestParam String name){

        return new ResponseEntity<>(starWarsService.searchCharacters(name), HttpStatus.OK);
    }
}
