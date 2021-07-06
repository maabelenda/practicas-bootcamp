package meli.bootcamp.practicaspring.models;

import com.google.gson.Gson;
import lombok.Data;

@Data
public class Morse {

    private String morsePhrase;
    private String decodePhrase;

    public Morse(String morsePhrase, String decodePhrase) {
        this.morsePhrase = morsePhrase;
        this.decodePhrase = decodePhrase;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
