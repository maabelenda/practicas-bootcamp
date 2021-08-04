package meli.bootcamp.practicajpa1.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DoctorDTO {

    private Long id;

    private String name;

    private String lastName;

    @JsonIgnore
    private Set<TurnDTO> turns;
}
