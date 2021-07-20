package meli.bootcamp.practicaspring2.controllers;

import meli.bootcamp.practicaspring2.dtos.request.StudentRequestDto;
import meli.bootcamp.practicaspring2.dtos.response.StudentResponseDto;
import meli.bootcamp.practicaspring2.exceptions.ObtenerDiplomaExceptionController;
import meli.bootcamp.practicaspring2.handlers.StudentHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {

    @PostMapping("/")
    public ResponseEntity<StudentResponseDto> calculateFinalScore(@Valid @RequestBody StudentRequestDto student){

        return new ResponseEntity<>(StudentHandler.calculateFinalScore(student), HttpStatus.OK);
    }
}
