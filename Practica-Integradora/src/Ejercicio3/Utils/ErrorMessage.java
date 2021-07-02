package Ejercicio3.Utils;

public enum ErrorMessage {

    BAD_ARGUMENTS("Revisa los argumentos ingresados", "001"),
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
