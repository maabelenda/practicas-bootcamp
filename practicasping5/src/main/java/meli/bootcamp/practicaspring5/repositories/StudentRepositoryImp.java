package meli.bootcamp.practicaspring5.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import meli.bootcamp.practicaspring5.daos.StudentDAO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class StudentRepositoryImp implements StudentRepository {

    private final AtomicInteger index = new AtomicInteger(lastStudentId());

    private final Map<Integer, StudentDAO> students = loadStudents();

    @Override
    public StudentDAO findStudentById(Integer id) {
        if(students.containsKey(id)) {
            return students.get(id);
        }
        return null;
    }

    @Override
    public List<StudentDAO> getAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public StudentDAO delete(StudentDAO student) {
        if(Objects.nonNull(student))
            return students.remove(student.getId());
        return null;
    }

    @Override
    public StudentDAO create(String name) {
        if(Objects.isNull(name)) {
            return null;
        }
        StudentDAO studentDAO = new StudentDAO(name, index.addAndGet(1));
        students.put(studentDAO.getId(), studentDAO);
        return studentDAO;
    }

    @Override
    public StudentDAO update(StudentDAO student) {
        if(Objects.nonNull(student) && students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return student;
        }
        return null;
    }

    private static Integer lastStudentId() {
        List<StudentDAO> list = loadDatabase();
        if(Objects.isNull(list)) {
            return 0;
        }
        Optional<StudentDAO> max = list.stream().max(Comparator.comparing(StudentDAO::getId));
        return max.isPresent() ? max.get().getId() : 0;
    }

    private static Map<Integer, StudentDAO> loadStudents() {
        List<StudentDAO> list = loadDatabase();
        Map<Integer, StudentDAO> studentDTOMap = new HashMap<>();
        if(Objects.isNull(list)) {
            return studentDTOMap;
        }
        for(StudentDAO l : list) {
            studentDTOMap.put(l.getId(), l);
        }
        return studentDTOMap;
    }

    private static List<StudentDAO> loadDatabase(){
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:students.json");
        }catch (FileNotFoundException e){
            //e.printStackTrace();
        }

        return mapObject(file);
    }

    private static List<StudentDAO> mapObject(File file){
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<StudentDAO>> typeReference = new TypeReference<>(){};
        List<StudentDAO> students = null;
        try {
            students = objectMapper.readValue(file, typeReference);
        }catch (IOException e){
            //e.printStackTrace();
        }

        return students;
    }
}
