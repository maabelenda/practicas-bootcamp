package meli.bootcamp.practicajpa1.repository;

import meli.bootcamp.practicajpa1.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient getPatientById(Long id);

    @Query("FROM Patient p JOIN Turn t ON p.id = t.patient.id WHERE function('DATE', t.date) LIKE :date")
    List<Patient> getPatientByDate(Date date);
}
