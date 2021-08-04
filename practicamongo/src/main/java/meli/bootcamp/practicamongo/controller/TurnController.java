package meli.bootcamp.practicamongo.controller;

import meli.bootcamp.practicamongo.model.dto.TurnDTO;
import meli.bootcamp.practicamongo.service.TurnService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turn")
public class TurnController {

    TurnService turnService;

    public TurnController(TurnService turnService) {
        this.turnService = turnService;
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody TurnDTO request){
        turnService.crateTurn(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TurnDTO>> getAll() {
        return new ResponseEntity<>(turnService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getByDoctorLastName")
    public ResponseEntity<List<TurnDTO>> getByDoctorLastName(@RequestParam("lastName") String lastName) {
        return new ResponseEntity<>(turnService.getTurnByDoctorLastName(lastName), HttpStatus.OK);
    }

    @GetMapping("/getByStatus")
    public ResponseEntity<List<TurnDTO>> getByStatus(@RequestParam("status") String status) {
        return new ResponseEntity<>(turnService.getTurnByStatus(status), HttpStatus.OK);
    }

}

