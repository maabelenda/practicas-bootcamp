package meli.bootcamp.practicaspring2.controllers;

import meli.bootcamp.practicaspring2.dtos.response.AgeDto;
import meli.bootcamp.practicaspring2.exceptions.ObtenerDiplomaExceptionController;
import meli.bootcamp.practicaspring2.handlers.AgeHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("/age")
@Validated
public class AgeController {

    @GetMapping("/{day}/{month}/{year}/")
    public ResponseEntity<AgeDto> totalMeters(@Valid @Pattern(regexp = "^[0-3][0-9]$") @PathVariable String day,
                                              @Valid @Pattern(regexp = "^[0-1][0-9]$") @PathVariable String month,
                                              @Valid @Pattern(regexp = "^[1-2][0-9]{3}$") @PathVariable String year){
        AgeHandler.validateDate(day, month, year);
        AgeDto ageDto = new AgeDto(AgeHandler.getAge(day, month, year));
        return new ResponseEntity<>(ageDto, HttpStatus.OK);
    }
}
