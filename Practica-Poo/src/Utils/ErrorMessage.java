package Utils;

public enum ErrorMessage {

    NULL_ACCOUNT("La cuenta corriente null", "001"),
    NEGATIVE_INPUT("saldo ingresado negativo o cero", "002"),
    NEGATIVE_BALANCE("El saldo de egreso es mayor al de que posee la cuenta", "003"),
    NULL_BOOK("El libro no puede ser nulo", "004"),

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
