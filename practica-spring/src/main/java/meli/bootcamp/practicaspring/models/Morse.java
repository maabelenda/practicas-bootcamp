package meli.bootcamp.practicaspring.models;

import lombok.Data;

@Data
public class Morse {

    private static final String THREE_SPACES = "   ", SPACE = " ";

    private String morsePhrase;

    public Morse(String morsePhrase) {
        this.morsePhrase = morsePhrase;
    }

    public String translate() {
        String [] listOfWords = this.morsePhrase.split(THREE_SPACES);


        StringBuffer resp = new StringBuffer();

        for(int i = 0 ; i < listOfWords.length ; i++) {
            String [] list = listOfWords[i].split(SPACE);

            for(int j = 0 ; j < list.length ; j++) {
                MorseValue morseValue = MorseValue.getValue(list[j]);
                resp.append(morseValue.getValue());
            }
            resp.append(SPACE);
        }
        return resp.toString();
    }
}
