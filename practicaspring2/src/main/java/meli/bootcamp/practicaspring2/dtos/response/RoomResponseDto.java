package meli.bootcamp.practicaspring2.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoomResponseDto {

    private String name;
    private Double wide;
    private Double longitude;
    private Double area;
}
