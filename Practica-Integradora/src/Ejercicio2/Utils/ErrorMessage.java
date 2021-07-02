package Ejercicio2.Utils;

public enum ErrorMessage {

    BAD_ARGUMENTS("Revisa los argumentos ingresados", "001"),
    NOT_FOUND_VEHICLE("No se encontro el vehiculo", "002"),
    RACER_ALREADY_EXIST("El corredor ya esta inscripto", "003"),
    EXCEEDED_MAX_RACE_SIZE("Se supero el maximo de vehiculos permitidos", "004"),
    BAD_LIFEGUARD("El tipo de socorrista no puede atender al vehiculo","005"),
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
