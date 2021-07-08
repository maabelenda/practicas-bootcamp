package meli.bootcamp.practicaspring4.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkIdResponseDTO {
    private String url;
    private Integer linkId;
}
