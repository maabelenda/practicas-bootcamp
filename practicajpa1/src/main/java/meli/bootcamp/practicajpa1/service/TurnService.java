package meli.bootcamp.practicajpa1.service;

import meli.bootcamp.practicajpa1.dto.TurnDTO;
import meli.bootcamp.practicajpa1.model.Turn;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TurnService {

    void createTurn(TurnDTO request);
    void deleteTurn(Long id);
    TurnDTO getTurn(Long id);
    void updateState(TurnDTO request);
    List<TurnDTO> getEnded();
    List<TurnDTO> getPendingByDate(String date);
    List<TurnDTO> getAgenda(String date, Long id);
    List<TurnDTO> getReprogramadosByDoctorId(Long id);
    List<TurnDTO> getReprogramados();
}
