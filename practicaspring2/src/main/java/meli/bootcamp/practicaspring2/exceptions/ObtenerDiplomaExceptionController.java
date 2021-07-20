package meli.bootcamp.practicaspring2.exceptions;

import lombok.Data;

import java.util.Map;

@Data
public class ObtenerDiplomaExceptionController extends RuntimeException {
    private ErrorDTO errorDTO;

    public ObtenerDiplomaExceptionController(Integer status, String error, Map<String, String> message) {
        this.errorDTO = new ErrorDTO(status, error, message);
    }

    public ObtenerDiplomaExceptionController(ErrorDTO errorDTO) {
        this.errorDTO = errorDTO;
    }
}
