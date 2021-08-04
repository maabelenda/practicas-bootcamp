package meli.bootcamp.practicajpa1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="turn")
@SequenceGenerator(initialValue = 1, name = "idTurn", sequenceName = "turnSec")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idTurn")
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="patient_id", nullable = false)
    private Patient patient;

    @Column(name="date", columnDefinition="Timestamp")
    private LocalDateTime date;

    @Column(name="duration")
    private Integer duration;

    @Column(name="status")
    private String status;

    @OneToOne
    @JoinColumn(name="new_turn_id", referencedColumnName = "id")
    @JsonBackReference
    private Turn newTurn;
}
