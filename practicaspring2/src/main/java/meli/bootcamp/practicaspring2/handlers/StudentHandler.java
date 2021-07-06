package meli.bootcamp.practicaspring2.handlers;

import meli.bootcamp.practicaspring2.dtos.request.StudentRequestDto;
import meli.bootcamp.practicaspring2.dtos.request.SubjectDto;
import meli.bootcamp.practicaspring2.dtos.response.StudentResponseDto;

public class StudentHandler{

    public static StudentResponseDto calculateFinalScore(StudentRequestDto request){

        Double average = 0.0;
        for(SubjectDto s : request.getSubjects()) {
            average += s.getScore();
        }
        average /= request.getSubjects().size();
        if(average > 9.0) {
            return new StudentResponseDto(request.getName(), "felicitaciones crack", average);
        }
        if(average >= 7.0) {
            return new StudentResponseDto(request.getName(), "aprobado", average);
        }
        return new StudentResponseDto(request.getName(), "reprobado", average);

    }
}
