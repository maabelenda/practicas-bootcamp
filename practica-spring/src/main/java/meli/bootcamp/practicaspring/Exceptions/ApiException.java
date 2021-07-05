package meli.bootcamp.practicaspring.Exceptions;

import lombok.Data;

import java.util.function.Supplier;

@Data
public class ApiException extends RuntimeException implements Supplier<ApiException> {

    private final String code;
    private final String description;
    private final Integer statusCode;

    public ApiException(String code, String description, Integer statusCode) {
        super(description);
        this.code = code;
        this.description = description;
        this.statusCode = statusCode;
    }

    public ApiException(String code, String description, Integer statusCode, Throwable cause) {
        super(description, cause);
        this.code = code;
        this.description = description;
        this.statusCode = statusCode;
    }

    @Override
    public ApiException get() {
        return this;
    }
}
