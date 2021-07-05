package meli.bootcamp.practicaspring.controllers;

import meli.bootcamp.practicaspring.models.Morse;
import meli.bootcamp.practicaspring.models.NumberModifier;
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

    @GetMapping("/translate")
    public String romanToDecimalNumber(//@Valid @Pattern(regexp = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")
                                       @RequestParam(value="morseMessage") String morseMessage) {

        Morse morse = new Morse(morseMessage);
        return morse.translate();
    }
}
