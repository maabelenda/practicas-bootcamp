package meli.bootcamp.practicaspring.services;

import meli.bootcamp.practicaspring.models.Morse;
import meli.bootcamp.practicaspring.models.MorseValue;
import org.springframework.stereotype.Service;

@Service
public class MorseServiceImp implements MorseService {

    private static final String THREE_SPACES = "   ", SPACE = " ";

    @Override
    public Morse translate(String morsePhrase) {
        String [] listOfWords = morsePhrase.split(THREE_SPACES);


        StringBuffer resp = new StringBuffer();

        for(int i = 0 ; i < listOfWords.length ; i++) {
            String [] list = listOfWords[i].split(SPACE);

            for(int j = 0 ; j < list.length ; j++) {
                MorseValue morseValue = MorseValue.getValue(list[j]);
                resp.append(morseValue.getValue());
            }
            resp.append(SPACE);
        }
        return new Morse(morsePhrase, resp.toString());
    }
}
