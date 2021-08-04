package meli.bootcamp.practicajpa1.service;

import com.fasterxml.jackson.core.type.TypeReference;
import meli.bootcamp.practicajpa1.dto.*;
import meli.bootcamp.practicajpa1.model.Doctor;
import meli.bootcamp.practicajpa1.repository.DoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    ModelMapper mapper;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public void addDoctor(DoctorDTO request) {

        doctorRepository.save(mapper.map(request, Doctor.class));


    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public DoctorDTO getDoctor(Long id) {
        Doctor doctor = doctorRepository.getDoctorById(id);

        return new DoctorDTO(doctor.getId(), doctor.getName(), doctor.getLastName(),
                mapper.map(doctor.getTurns(), new TypeReference<Set<TurnDTO>>(){}.getType()));
    }

    @Override
    public void updateDoctor(DoctorDTO request, Long id) {
        Doctor doctor = mapper.map(request, Doctor.class);
        doctor.setId(id);
        doctorRepository.save(doctor);

    }

    @Override
    public Set<DoctorDTO> getDoctorConMasDedosTurnosEnUnDia() {
        return mapper.map(doctorRepository.getDoctorConMasDedosTurnosEnUnDia(), new TypeReference<Set<DoctorDTO>>(){}.getType());
    }

}
