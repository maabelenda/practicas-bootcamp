package meli.bootcamp.practicajpa1.repository;

import meli.bootcamp.practicajpa1.model.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface TurnRepository extends JpaRepository<Turn, Long> {
    Turn getTurnById(Long id);

    @Query("FROM Turn t WHERE t.status LIKE :status")
    List<Turn> getTurnByStatus(String status);

    @Query("FROM Turn t WHERE t.status LIKE 'Pendiente' AND function('DATE', t.date) LIKE :date")
    List<Turn> getPendingByDate(Date date);

    @Query("FROM Turn t WHERE t.doctor.id = :id AND t.status LIKE 'Pendiente' AND function('DATE', t.date) LIKE :date")
    List<Turn> getAgenda(Long id, Date date);

    @Query("FROM Turn t WHERE t.status LIKE 'Reprogramado' AND t.doctor.id = :id")
    List<Turn> getReprogramadosPorDentista(Long id);

    @Query("FROM Turn t WHERE t.status LIKE 'Reprogramado'")
    List<Turn> getReprogramados();
}
