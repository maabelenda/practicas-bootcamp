package meli.bootcamp.practicaspring5.services;

import meli.bootcamp.practicaspring5.daos.StudentDAO;
import meli.bootcamp.practicaspring5.dtos.request.CreateStudentDTO;
import meli.bootcamp.practicaspring5.dtos.request.UpdateStudentDTO;
import meli.bootcamp.practicaspring5.dtos.response.StudentResponseDTO;
import meli.bootcamp.practicaspring5.exceptions.ObtenerDiplomaExceptionController;
import meli.bootcamp.practicaspring5.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class StudentServiceImp implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void create(CreateStudentDTO request) {
        studentRepository.create(request.getName());
    }

    @Override
    public void delete(Integer studentId) {
        StudentDAO student = findStudent(studentId);
        studentRepository.delete(student);
    }

    @Override
    public void update(UpdateStudentDTO request) {
        StudentDAO studentDAO = findStudent(request.getId());
        studentDAO.setName(request.getName());
        studentRepository.update(studentDAO);
    }

    @Override
    public List<StudentResponseDTO> getAll() {
        return studentRepository.getAll().stream()
                .map(this::mapStudentDAOToStudentResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponseDTO getStudent(Integer studentId) {
        return mapStudentDAOToStudentResponseDTO(findStudent(studentId));
    }

    private StudentDAO findStudent(Integer id) {
        StudentDAO student = studentRepository.findStudentById(id);
        if(Objects.isNull(student)) {
            Map<String, String> errors = new HashMap<>();
            errors.put("id", "Not found student with id: " + id);
            throw new ObtenerDiplomaExceptionController(404, "Not Found", errors);
        }
        return student;
    }

    private StudentResponseDTO mapStudentDAOToStudentResponseDTO(StudentDAO studentDAO) {
        return new StudentResponseDTO(studentDAO.getName(), studentDAO.getId());
    }
}
