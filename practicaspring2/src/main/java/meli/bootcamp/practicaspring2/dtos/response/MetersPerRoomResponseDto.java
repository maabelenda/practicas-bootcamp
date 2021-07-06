package meli.bootcamp.practicaspring2.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MetersPerRoomResponseDto {

    List<RoomResponseDto> roomResponseDtoList;
}
