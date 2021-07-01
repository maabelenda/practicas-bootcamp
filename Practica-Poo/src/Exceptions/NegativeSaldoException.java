package Exceptions;

public class NegativeSaldoException extends ErrorException {

    public NegativeSaldoException(String message, String code) {
        super(message, code);
    }
}
