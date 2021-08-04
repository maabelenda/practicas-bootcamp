package meli.bootcamp.practicamongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "turn")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Turn {
    @MongoId
    private String id;

    private Patient patient;

    private Doctor doctor;

    private String date;

    private String status;
}
