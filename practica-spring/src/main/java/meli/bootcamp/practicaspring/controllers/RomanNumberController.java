package meli.bootcamp.practicaspring.controllers;

import meli.bootcamp.practicaspring.models.NumberModifier;
import meli.bootcamp.practicaspring.services.RomanNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("/romanNumber")
@Validated
public class RomanNumberController {

    @Autowired
    RomanNumberService romanNumberService;

    @GetMapping("/romanToDecimal")
    public ResponseEntity<NumberModifier> romanToDecimalNumber(@Valid @Pattern(regexp = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")
                                           @RequestParam(value="number") String number) {

        return new ResponseEntity<>(romanNumberService.romanToDecimal(number), HttpStatus.OK);
    }

    @GetMapping("/decimalToRoman")
    public ResponseEntity<NumberModifier> decimalToRomanNumber(@Valid @Pattern(regexp = "^[1-9][0-9]{0,3}$")
                                           @RequestParam(value="number") String number) {


        return new ResponseEntity<>(romanNumberService.decimalToRoman(number), HttpStatus.OK);
    }

}
