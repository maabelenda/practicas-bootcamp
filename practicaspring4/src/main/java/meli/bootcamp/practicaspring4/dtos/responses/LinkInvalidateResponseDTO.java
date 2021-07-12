package meli.bootcamp.practicaspring4.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkInvalidateResponseDTO {
    private Boolean invalidate;
    private Integer linkId;
}
