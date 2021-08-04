package meli.bootcamp.practicajpa1.service;

import meli.bootcamp.practicajpa1.dto.DoctorDTO;
import meli.bootcamp.practicajpa1.model.Doctor;

import java.util.List;
import java.util.Set;

public interface DoctorService {

    void addDoctor(DoctorDTO request);

    void deleteDoctor(Long id);

    DoctorDTO getDoctor(Long id);

    void updateDoctor(DoctorDTO request, Long id);

    Set<DoctorDTO> getDoctorConMasDedosTurnosEnUnDia();

}

