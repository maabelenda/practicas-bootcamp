package meli.bootcamp.practicaspring2.handlers;

import meli.bootcamp.practicaspring2.dtos.request.HouseRequestDto;
import meli.bootcamp.practicaspring2.dtos.request.RoomRequestDto;
import meli.bootcamp.practicaspring2.dtos.response.MetersPerRoomResponseDto;
import meli.bootcamp.practicaspring2.dtos.response.RateResponseDto;
import meli.bootcamp.practicaspring2.dtos.response.RoomResponseDto;

import java.util.ArrayList;
import java.util.List;


public class HouseHandler {

    private static Double VALUE = 800.0;
    private static String CURRENCY = "USD";

    public static Double getTotalMeters(HouseRequestDto request){

        Double totalMeters = 0.0;
        for(RoomRequestDto r : request.getRooms()) {
            totalMeters += r.getLongitude()*r.getWide();
        }
        return totalMeters;
    }

    public static RateResponseDto getRate(HouseRequestDto request) {
        Double rate = VALUE * getTotalMeters(request);
        return new RateResponseDto(rate, CURRENCY);
    }

    public static RoomResponseDto biggestRoom(HouseRequestDto request) {

        RoomRequestDto biggestRoom = request.getRooms().get(0);
        Double biggestArea = biggestRoom.getWide()*biggestRoom.getLongitude();
        for(RoomRequestDto r : request.getRooms()) {
            Double currentArea = r.getLongitude()*r.getWide();
            if(currentArea > biggestArea) {
                biggestRoom = r;
                biggestArea = currentArea;
            }
        }
        return new RoomResponseDto(biggestRoom.getName(), biggestRoom.getWide(), biggestRoom.getLongitude(), biggestArea);
    }

    public static MetersPerRoomResponseDto metersPerRoom(HouseRequestDto request) {
        List<RoomResponseDto> list = new ArrayList<>();
        for(RoomRequestDto r : request.getRooms()) {
            list.add(new RoomResponseDto(r.getName(), r.getWide(), r.getLongitude(), r.getWide()*r.getLongitude()));
        }
        return new MetersPerRoomResponseDto(list);
    }
}
