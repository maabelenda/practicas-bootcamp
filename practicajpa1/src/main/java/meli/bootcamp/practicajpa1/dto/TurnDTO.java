package meli.bootcamp.practicajpa1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class TurnDTO {

    private Long id;

    private DoctorDTO doctor;

    private PatientDTO patient;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    private String status;

    private TurnDTO newTurn;

}
