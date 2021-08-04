package meli.bootcamp.practicajpa1.repository;

import meli.bootcamp.practicajpa1.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Doctor getDoctorById(Long id);

    @Query("SELECT d FROM Doctor d JOIN Turn t ON d.id = t.doctor.id GROUP BY d, function('DATE', t.date) HAVING function('COUNT', function('DATE', t.date)) > 2")
    List<Doctor> getDoctorConMasDedosTurnosEnUnDia();
}
