package meli.bootcamp.practicaspring2.controllers;

import meli.bootcamp.practicaspring2.dtos.request.HouseRequestDto;
import meli.bootcamp.practicaspring2.dtos.response.MetersPerRoomResponseDto;
import meli.bootcamp.practicaspring2.dtos.response.RateResponseDto;
import meli.bootcamp.practicaspring2.dtos.response.RoomResponseDto;
import meli.bootcamp.practicaspring2.dtos.response.TotalMetersResponseDto;
import meli.bootcamp.practicaspring2.handlers.HouseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/house")
public class HouseController {

    @PostMapping("/totalMeters")
    public ResponseEntity<TotalMetersResponseDto> totalMeters(@Valid @RequestBody HouseRequestDto house){
        TotalMetersResponseDto totalMetersResponseDto = new TotalMetersResponseDto(
                HouseHandler.getTotalMeters(house));

        return new ResponseEntity<>(totalMetersResponseDto, HttpStatus.OK);
    }

    @PostMapping("/rate")
    public ResponseEntity<RateResponseDto> rateHouse(@Valid @RequestBody HouseRequestDto house){

        return new ResponseEntity<>(HouseHandler.getRate(house), HttpStatus.OK);
    }

    @PostMapping("/biggestRoom")
    public ResponseEntity<RoomResponseDto> biggestRoom(@Valid @RequestBody HouseRequestDto house){

        return new ResponseEntity<>(HouseHandler.biggestRoom(house), HttpStatus.OK);
    }

    @PostMapping("/metersPerRoom")
    public ResponseEntity<MetersPerRoomResponseDto> meterPerRooms(@Valid @RequestBody HouseRequestDto house){

        return new ResponseEntity<>(HouseHandler.metersPerRoom(house), HttpStatus.OK);
    }

}
