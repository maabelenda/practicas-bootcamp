package meli.bootcamp.practicaspring.services;

import meli.bootcamp.practicaspring.models.Morse;

public interface MorseService {

    Morse translate(String morseMessage);
}
