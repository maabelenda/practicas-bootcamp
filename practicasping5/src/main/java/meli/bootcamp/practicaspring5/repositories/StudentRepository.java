package meli.bootcamp.practicaspring5.repositories;

import meli.bootcamp.practicaspring5.daos.StudentDAO;

import java.util.List;

public interface StudentRepository {

    StudentDAO findStudentById(Integer id);
    List<StudentDAO> getAll();
    StudentDAO delete(StudentDAO student);
    StudentDAO create(String name);
    StudentDAO update(StudentDAO student);

}
