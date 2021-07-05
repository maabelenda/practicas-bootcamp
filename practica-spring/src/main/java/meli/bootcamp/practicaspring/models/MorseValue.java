package meli.bootcamp.practicaspring.models;

import lombok.Getter;
import meli.bootcamp.practicaspring.Exceptions.ApiException;

import java.util.Arrays;

@Getter
public enum MorseValue {

    A(".-","A"),
    B("-...","B"),
    C("-.-.","C"),
    D("-..","D"),
    E(".","E"),
    F("..-.","F"),
    G("--.","G"),
    H("....","H"),
    I("..","I"),
    J(".---","J"),
    K("-.-","K"),
    L(".-..","L"),
    M("--","M"),
    N("-.","N"),
    Ñ("--.--","Ñ"),
    O("---","O"),
    P(".--.","P"),
    Q("--.-","Q"),
    R(".-.","R"),
    S("...","S"),
    T("-","T"),
    U("..-","U"),
    V("...-","V"),
    W(".--","W"),
    X("-..-","X"),
    Y("-.--","Y"),
    Z("--..","Z"),
    ZERO("-----","0"),
    ONE(".----","1"),
    TWO("..---","2"),
    THREE("...--","3"),
    FOUR("....-","4"),
    FIVE(".....","5"),
    SIX("-....","6"),
    SEVEN("--...","7"),
    EIGHT("---..","8"),
    NINE("----.","9"),
    ;

    private String morseValue;
    private String value;

    MorseValue(String morseValue, String value) {
        this.morseValue = morseValue;
        this.value = value;
    }

    public static MorseValue getValue(String morseValue) {
        return Arrays.stream(MorseValue.values()).filter(v -> v.morseValue.equals(morseValue)).findAny()
                .orElseThrow(new ApiException("003", "bad request", 400));
    }
}