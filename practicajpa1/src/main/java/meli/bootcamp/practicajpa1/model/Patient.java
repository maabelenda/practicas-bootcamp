package meli.bootcamp.practicajpa1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
@SequenceGenerator(initialValue = 1, name = "idPatient", sequenceName = "patientSec")
@Table(name="patient")
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idPatient")
    private Long id;

    @Column(name="name", nullable = false, length = 50)
    private String name;

    @Column(name="last_name", nullable = false, length = 50)
    private String lastName;

    @OneToMany(mappedBy = "patient")
    private Set<Turn> turns;
}
