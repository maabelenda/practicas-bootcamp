package meli.bootcamp.practicaspring4.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkDTO {

    private Integer linkId;
    private String url;
    private boolean isValid;
    private Long cantRedirect;
    private String password;
}
