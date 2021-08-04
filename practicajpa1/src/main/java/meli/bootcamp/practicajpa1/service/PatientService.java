package meli.bootcamp.practicajpa1.service;

import meli.bootcamp.practicajpa1.dto.PatientDTO;

import java.util.Set;

public interface PatientService {

    void addPatient(PatientDTO request);

    void deletePatient(Long id);

    PatientDTO getPatient(Long id);

    void updatePatient(PatientDTO request, Long id);

    Set<PatientDTO> getPatientByDay(String date);
}
