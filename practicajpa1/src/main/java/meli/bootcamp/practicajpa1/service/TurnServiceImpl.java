package meli.bootcamp.practicajpa1.service;

import com.fasterxml.jackson.core.type.TypeReference;
import meli.bootcamp.practicajpa1.dto.DoctorDTO;
import meli.bootcamp.practicajpa1.dto.TurnDTO;
import meli.bootcamp.practicajpa1.model.Turn;
import meli.bootcamp.practicajpa1.repository.TurnRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class TurnServiceImpl implements TurnService {

    private TurnRepository turnRepository;
    private DoctorService doctorService;

    @Autowired
    ModelMapper mapper;

    public TurnServiceImpl(TurnRepository turnRepository, DoctorService doctorService) {
        this.turnRepository = turnRepository;
        this.doctorService = doctorService;
    }

    @Override
    public void createTurn(TurnDTO request) {
        Turn turn = mapper.map(request, Turn.class);
        turn.setDuration(30);
        DoctorDTO doctorDTO = doctorService.getDoctor(request.getDoctor().getId());
        if(doctorDTO.getTurns().stream().noneMatch((t) -> {
            Date tdate = java.util.Date
                    .from(t.getDate().atZone(ZoneId.systemDefault())
                            .toInstant());
            Date date = java.util.Date
                    .from(request.getDate().atZone(ZoneId.systemDefault())
                            .toInstant());
            return (Math.abs((tdate.getTime() - date.getTime()) / (60 * 1000)) < 30);
        })) {
            turnRepository.save(turn);

        }
    }

    @Override
    public void deleteTurn(Long id) {
        turnRepository.deleteById(id);
    }

    @Override
    public TurnDTO getTurn(Long id) {
        Turn turn = turnRepository.getTurnById(id);
        return mapper.map(turn, TurnDTO.class);
    }

    @Override
    public void updateState(TurnDTO request) {
        Turn turn = turnRepository.getById(request.getId());
        if(Objects.nonNull(request.getNewTurn())) {
            Turn newTurn = turnRepository.save(mapper.map(request.getNewTurn(), Turn.class));
            turn.setNewTurn(newTurn);
        }
        turn.setStatus(request.getStatus());
        turnRepository.save(turn);
    }

    @Override
    public List<TurnDTO> getEnded() {
        return mapper.map(turnRepository.getTurnByStatus("Finalizado"), new TypeReference<List<TurnDTO>>(){}.getType());
    }

    @Override
    public List<TurnDTO> getPendingByDate(String date) {
        return mapper.map(turnRepository.getPendingByDate(java.sql.Date.valueOf(date)), new TypeReference<List<TurnDTO>>(){}.getType());
    }

    @Override
    public List<TurnDTO> getAgenda(String date, Long id) {
        return mapper.map(turnRepository.getAgenda(id, java.sql.Date.valueOf(date)), new TypeReference<List<TurnDTO>>(){}.getType());
    }

    @Override
    public List<TurnDTO> getReprogramadosByDoctorId(Long id) {
        return mapper.map(turnRepository.getReprogramadosPorDentista(id), new TypeReference<List<TurnDTO>>(){}.getType());
    }

    @Override
    public List<TurnDTO> getReprogramados() {
        return mapper.map(turnRepository.getReprogramados(), new TypeReference<List<TurnDTO>>(){}.getType());
    }
}
