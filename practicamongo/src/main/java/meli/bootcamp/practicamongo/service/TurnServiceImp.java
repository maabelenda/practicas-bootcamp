package meli.bootcamp.practicamongo.service;

import com.fasterxml.jackson.core.type.TypeReference;
import meli.bootcamp.practicamongo.model.Turn;
import meli.bootcamp.practicamongo.model.dto.TurnDTO;
import meli.bootcamp.practicamongo.repository.TurnRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnServiceImp implements TurnService {

    private TurnRepository turnRepository;

    @Autowired
    private ModelMapper mapper;

    public TurnServiceImp(TurnRepository turnRepository) {
        this.turnRepository = turnRepository;
    }

    @Override
    public void crateTurn(TurnDTO request) {
        turnRepository.save(mapper.map(request, Turn.class));
    }

    @Override
    public List<TurnDTO> getAll() {

        return mapper.map(turnRepository.getTurns(),
                new TypeReference<List<TurnDTO>>(){}.getType());
    }

    @Override
    public List<TurnDTO> getTurnByDoctorLastName(String lastName) {
        return mapper.map(turnRepository.getTurnByDoctorLastName(lastName),
                new TypeReference<List<TurnDTO>>(){}.getType());
    }

    @Override
    public List<TurnDTO> getTurnByStatus(String status) {
        return mapper.map(turnRepository.getTurnByStatus1(status),
                new TypeReference<List<TurnDTO>>(){}.getType());    }
}
