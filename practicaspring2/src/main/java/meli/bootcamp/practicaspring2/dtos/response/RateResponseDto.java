package meli.bootcamp.practicaspring2.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RateResponseDto {

    private Double rate;
    private String currency;
}
