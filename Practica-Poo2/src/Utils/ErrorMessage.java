package Utils;

public enum ErrorMessage {

    BAD_PASSWORD("Contraseña invalida", "001"),
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
