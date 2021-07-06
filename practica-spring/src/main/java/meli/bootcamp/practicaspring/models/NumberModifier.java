package meli.bootcamp.practicaspring.models;


import com.google.gson.Gson;
import lombok.Data;

@Data
public class NumberModifier {

    private String romanNumber;
    private String decimalNumber;

    public NumberModifier(String romanNumber, String decimalNumber) {
        this.romanNumber = romanNumber;
        this.decimalNumber = decimalNumber;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
