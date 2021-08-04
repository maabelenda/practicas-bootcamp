package meli.bootcamp.practicamongo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurnDTO {
    @MongoId
    private String id;

    private PatientDTO patient;

    private DoctorDTO doctor;

    private String date;

    private String status;
}
