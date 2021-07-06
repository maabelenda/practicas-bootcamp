package meli.bootcamp.practicaspring.controllers;

import meli.bootcamp.practicaspring.models.Morse;
import meli.bootcamp.practicaspring.services.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("/morse")
@Validated
public class MorseController {

    @Autowired
    MorseService morseService;

    @GetMapping("/translate")
    public ResponseEntity<Morse> romanToDecimalNumber(@Valid @Pattern(regexp = "^[.-]{1,5}(?> [.-]{1,5})*(?>   [.-]{1,5}(?> [.-]{1,5})*)*$")
                                                      @RequestParam(value="morseMessage") String morseMessage) {

        return new ResponseEntity<>(morseService.translate(morseMessage), HttpStatus.OK);
    }
}
