package meli.bootcamp.practicajpa1.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import meli.bootcamp.practicajpa1.dto.DoctorDTO;
import meli.bootcamp.practicajpa1.dto.PatientDTO;
import meli.bootcamp.practicajpa1.dto.TurnDTO;
import meli.bootcamp.practicajpa1.model.Patient;
import meli.bootcamp.practicajpa1.model.Turn;
import meli.bootcamp.practicajpa1.service.DoctorService;
import meli.bootcamp.practicajpa1.service.PatientService;
import meli.bootcamp.practicajpa1.service.TurnService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Controller
public class SurgeryController {

    PatientService patientService;

    TurnService turnService;

    DoctorService doctorService;

    public SurgeryController(PatientService patientService, TurnService turnService, DoctorService doctorService) {
        this.patientService = patientService;
        this.turnService = turnService;
        this.doctorService = doctorService;
    }

    @PostMapping(value = "/patient/create")
    public ResponseEntity<Void> createPatient(@RequestBody PatientDTO request) {
        patientService.addPatient(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/patient/delete")
    public ResponseEntity<Void> deletePatient(@RequestParam(value = "id") Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/patient/get")
    public ResponseEntity<PatientDTO> getPatient(@RequestParam(value = "id") Long id) {

        return new ResponseEntity<>(patientService.getPatient(id),HttpStatus.OK);
    }

    @PostMapping(value = "/patient/update")
    public ResponseEntity<Void> updatePatient(@RequestBody PatientDTO request, @RequestParam(value = "id") Long id) {
        patientService.updatePatient(request, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/doctor/create")
    public ResponseEntity<Void> createDoctor(@RequestBody DoctorDTO request) {
        doctorService.addDoctor(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/doctor/delete")
    public ResponseEntity<Void> deleteDoctor(@RequestParam(value = "id") Long id) {
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/doctor/get")
    public ResponseEntity<DoctorDTO> getDoctor(@RequestParam(value = "id") Long id) {

        return new ResponseEntity<>(doctorService.getDoctor(id),HttpStatus.OK);
    }

    @PostMapping(value = "/doctor/update")
    public ResponseEntity<Void> updateDoctor(@RequestBody DoctorDTO request, @RequestParam(value = "id") Long id) {
        doctorService.updateDoctor(request, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/turn/create")
    public ResponseEntity<Void> createTurn(@RequestBody TurnDTO request) {
        turnService.createTurn(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/turn/delete")
    public ResponseEntity<Void> deleteTurn(@RequestParam(value = "id") Long id) {
        turnService.deleteTurn(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/turn/update")
    public ResponseEntity<Void> updateTurn(@RequestBody TurnDTO request) {
        turnService.updateState(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/turn/get")
    public ResponseEntity<TurnDTO> getTurn(@RequestParam(value = "id") Long id) {

        return new ResponseEntity<>(turnService.getTurn(id), HttpStatus.OK);
    }

    @GetMapping(value = "/turn/finalizados")
    public ResponseEntity<List<TurnDTO>> getTurnFinalizado() {

        return new ResponseEntity<>( turnService.getEnded(), HttpStatus.OK);
    }

    @GetMapping(value = "/turn/pendientesDate")
    public ResponseEntity<List<TurnDTO>> getPendienteDate(@RequestParam(value = "date") String date) {

        return new ResponseEntity<>( turnService.getPendingByDate(date), HttpStatus.OK);
    }

    @GetMapping(value = "/turn/agenda")
    public ResponseEntity<List<TurnDTO>> getAgenda(@RequestParam(value = "date") String date,
                                                   @RequestParam(value = "id") Long id) {
        return new ResponseEntity<>( turnService.getAgenda(date, id), HttpStatus.OK);
    }

    @GetMapping(value = "/turn/reprogramadosPorDoctor")
    public ResponseEntity<List<TurnDTO>> getReprogPorDoc(@RequestParam(value = "id") Long id) {
        return new ResponseEntity<>( turnService.getReprogramadosByDoctorId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/turn/reprogramados")
    public ResponseEntity<List<TurnDTO>> getReprog() {
        return new ResponseEntity<>( turnService.getReprogramados(), HttpStatus.OK);
    }

    @GetMapping(value = "/patient/date")
    public ResponseEntity<Set<PatientDTO>> getdate(@RequestParam(value = "date") String date) {
        return new ResponseEntity<>( patientService.getPatientByDay(date), HttpStatus.OK);
    }

    @GetMapping(value = "/doctor/conMasTurnos")
    public ResponseEntity<Set<DoctorDTO>> getdate() {
        return new ResponseEntity<>( doctorService.getDoctorConMasDedosTurnosEnUnDia(), HttpStatus.OK);
    }

}
