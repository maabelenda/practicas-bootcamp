package meli.bootcamp.practicaspring5.services;

import meli.bootcamp.practicaspring5.dtos.request.CreateStudentDTO;
import meli.bootcamp.practicaspring5.dtos.request.UpdateStudentDTO;
import meli.bootcamp.practicaspring5.dtos.response.StudentResponseDTO;

import java.util.List;

public interface StudentService {

    void create(CreateStudentDTO request);
    void delete(Integer studentId);
    void update(UpdateStudentDTO request);
    List<StudentResponseDTO> getAll();
    StudentResponseDTO getStudent(Integer studentId);


}
