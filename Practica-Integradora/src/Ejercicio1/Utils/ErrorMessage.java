package Ejercicio1.Utils;

public enum ErrorMessage {

    NULL_PRENDAS("La lista de prendas no puede ser nula o vacia", "001"),
    NOT_FOUND_PRENDAS("No se encontro numero de prendas", "002"),
    ;

    String message;
    String code;

    ErrorMessage(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
