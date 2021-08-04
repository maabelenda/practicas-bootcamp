package meli.bootcamp.practicaspring5.handlers;

import meli.bootcamp.practicaspring5.dtos.request.ObtainDiplomaRequestDTO;
import meli.bootcamp.practicaspring5.dtos.request.SubjectDto;
import meli.bootcamp.practicaspring5.dtos.response.ObtainDiplomaResponseDto;

public class StudentHandler{

    public static ObtainDiplomaResponseDto calculateFinalScore(ObtainDiplomaRequestDTO request){

        Double average = 0.0;
        for(SubjectDto s : request.getSubjects()) {
            average += s.getScore();
        }
        average /= request.getSubjects().size();
        if(average > 9.0) {
            return new ObtainDiplomaResponseDto(request.getName(), "felicitaciones crack", average);
        }
        if(average >= 7.0) {
            return new ObtainDiplomaResponseDto(request.getName(), "aprobado", average);
        }
        return new ObtainDiplomaResponseDto(request.getName(), "reprobado", average);

    }
}
