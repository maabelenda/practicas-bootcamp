package meli.bootcamp.practicamongo.service;

import meli.bootcamp.practicamongo.model.dto.TurnDTO;

import java.util.List;

public interface TurnService {

    void crateTurn(TurnDTO request);
    List<TurnDTO> getAll();
    List<TurnDTO> getTurnByDoctorLastName(String lastName);
    List<TurnDTO> getTurnByStatus(String status);

}
