package meli.bootcamp.practicaspring5.controllers;

import meli.bootcamp.practicaspring5.dtos.request.ObtainDiplomaRequestDTO;
import meli.bootcamp.practicaspring5.dtos.response.ObtainDiplomaResponseDto;
import meli.bootcamp.practicaspring5.handlers.StudentHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
public class ObtainDiplomaController {

    @PostMapping("/")
    public ResponseEntity<ObtainDiplomaResponseDto> calculateFinalScore(@Valid @RequestBody ObtainDiplomaRequestDTO student){

        return new ResponseEntity<>(StudentHandler.calculateFinalScore(student), HttpStatus.OK);
    }
}
