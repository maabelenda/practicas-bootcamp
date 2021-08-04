package meli.bootcamp.practicajpa1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "doctor")
@SequenceGenerator(initialValue = 1, name = "idDoctor", sequenceName = "doctorSec")
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idDoctor")
    private Long id;

    @Column(name="name", nullable = false, length = 50)
    private String name;

    @Column(name="last_name", nullable = false, length = 50)
    private String lastName;

    @OneToMany(mappedBy = "doctor")
    private Set<Turn> turns;

}