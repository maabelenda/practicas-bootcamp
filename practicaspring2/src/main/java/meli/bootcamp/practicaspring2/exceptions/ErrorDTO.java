package meli.bootcamp.practicaspring2.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {

    private Integer status;
    private String error;
    private Map<String, String> message;

}
