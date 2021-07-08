package meli.bootcamp.practicaspring4.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkMetricsResponseDTO {

    private Long cantRedirect;
    private Integer linkId;
}
