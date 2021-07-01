package Exceptions;

public class ErrorException extends Exception {

    private String message;
    private String code;

    public ErrorException() {
        super();
    }

    public ErrorException(String message, String code) {
        super();
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
