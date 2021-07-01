package Exceptions;

public class BadPasswordException extends ErrorException {

    public BadPasswordException(String message, String code) {
        super(message, code);
    }
}
