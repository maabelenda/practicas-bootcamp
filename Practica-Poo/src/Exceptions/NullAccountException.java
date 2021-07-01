package Exceptions;

public class NullAccountException extends ErrorException {

    public NullAccountException(String message, String code) {
        super(message, code);
    }
}
