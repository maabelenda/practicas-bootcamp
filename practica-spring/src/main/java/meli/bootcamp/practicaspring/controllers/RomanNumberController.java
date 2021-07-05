package meli.bootcamp.practicaspring.controllers;

import meli.bootcamp.practicaspring.models.NumberModifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("/romanNumber")
@Validated
public class RomanNumberController {


    @GetMapping("/romanToDecimal")
    public String romanToDecimalNumber(@Valid @Pattern(regexp = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")
                                           @RequestParam(value="number") String number) {

        NumberModifier numberModifier = new NumberModifier();
        numberModifier.setRomanNumber(number);
        return numberModifier.romanToDecimal().toString();
    }

    @GetMapping("/decimalToRoman")
    public String decimalToRomanNumber(@Valid @Pattern(regexp = "^[1-9][0-9]{0,3}$")
                                           @RequestParam(value="number") String number) {
        NumberModifier numberModifier = new NumberModifier();
        numberModifier.setDecimalNumber(number);
        return numberModifier.decimalToRoman();
    }

}
