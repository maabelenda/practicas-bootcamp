package meli.bootcamp.practicajpa1.service;

import com.fasterxml.jackson.core.type.TypeReference;
import meli.bootcamp.practicajpa1.dto.*;
import meli.bootcamp.practicajpa1.model.Patient;
import meli.bootcamp.practicajpa1.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class PatientServiceImpl implements PatientService {

    PatientRepository patientRepository;

    @Autowired
    ModelMapper mapper;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void addPatient(PatientDTO request) {
        patientRepository.save(mapper.map(request, Patient.class));
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public PatientDTO getPatient(Long id) {
        Patient patient = patientRepository.getPatientById(id);
        return new PatientDTO(patient.getId(), patient.getName(), patient.getLastName(),
                mapper.map(patient.getTurns(),  new TypeReference<Set<TurnDTO>>(){}.getType()));
    }

    @Override
    public void updatePatient(PatientDTO request, Long id) {
        Patient patient = mapper.map(request, Patient.class);
        patient.setId(id);
        patientRepository.save(patient);

    }

    @Override
    public Set<PatientDTO> getPatientByDay(String date) {
        return mapper.map(patientRepository.getPatientByDate(java.sql.Date.valueOf(date)), new TypeReference<Set<PatientDTO>>(){}.getType());

    }

}
