package meli.bootcamp.practicaspring4.exceptions;

import lombok.Getter;

import java.util.Map;
import java.util.Objects;

@Getter
public class ErrorMessage {

    private Integer status;
    private String error;
    private Map<String, String> message;

    public ErrorMessage(Integer status, String error, Map<String, String> message){
        this.status = status;
        this.error = error;
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorMessage that = (ErrorMessage) o;
        return Objects.equals(status, that.status) && Objects.equals(error, that.error) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, error, message);
    }
}
