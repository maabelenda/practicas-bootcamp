package meli.bootcamp.practicaspring.services;

import meli.bootcamp.practicaspring.models.NumberModifier;

public interface RomanNumberService {

    NumberModifier decimalToRoman(String number);
    NumberModifier romanToDecimal(String number);

}
