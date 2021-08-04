package meli.bootcamp.practicaspring5.units.repository;


import meli.bootcamp.practicaspring5.daos.StudentDAO;
import meli.bootcamp.practicaspring5.repositories.StudentRepositoryImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Unit Test - Student Repository Impl")
public class RepositoryTest {

    StudentRepositoryImp repo = new StudentRepositoryImp();

    @Test
    @Rollback
    @DisplayName("Found Student by Id")
    void foundStudent() {
        //arrange
        Integer studentId = 1;
        StudentDAO expected =  new StudentDAO("Carlos A", 1);

        //act
        StudentDAO current = repo.findStudentById(studentId);

        //assert
        Assertions.assertEquals(expected, current);
    }

    @Test
    @Rollback
    @DisplayName("Not found Student")
    void notFoundStudent() {
        //arrange

        //arrange
        Integer studentId = 5;

        //act
        StudentDAO current = repo.findStudentById(studentId);

        //assert
        Assertions.assertNull(current);

    }

    @Test
    @Rollback
    @DisplayName("Create Student")
    void createStudent() {
        //arrange
        String name = "Pedro E";
        StudentDAO expected =  new StudentDAO("Pedro E", 5);

        //act
        StudentDAO current = repo.create(name);

        //assert
        Assertions.assertEquals(expected, current);
    }

    @Test
    @Rollback
    @DisplayName("Create Student (null)")
    void createNullStudent() {

        //act
        StudentDAO current = repo.create(null);

        //assert
        Assertions.assertNull(current);
    }

    @Test
    @Rollback
    @DisplayName("update Student")
    void updateStudent() {
        //arrange
        StudentDAO studentDAO =  new StudentDAO("Pepe A", 4);
        StudentDAO expected =  new StudentDAO("Pepe A", 4);

        //act
        StudentDAO current = repo.update(studentDAO);

        //assert
        Assertions.assertEquals(current, expected);

    }

    @Test
    @Rollback
    @DisplayName("update Student - Not Found")
    void notFoundUpdateStudent() {
        //arrange
        StudentDAO studentDAO =  new StudentDAO("Pepe L", 5);

        //act
        StudentDAO current = repo.update(studentDAO);

        //assert
        Assertions.assertNull(current);

    }

    @Test
    @Rollback
    @DisplayName("update Student - Not Found (null)")
    void notFoundNullUpdateStudent() {
        //arrange
        StudentDAO studentDAO =  new StudentDAO("Pepe L", 5);

        //act
        StudentDAO current = repo.update(studentDAO);

        //assert
        Assertions.assertNull(current);

    }

    @Test
    @Rollback
    @DisplayName("delete Student")
    void deleteStudent() {
        //arrange
        StudentDAO studentDAO =  new StudentDAO("Pepe D", 4);
        StudentDAO expected =  new StudentDAO("Pepe D", 4);

        //act
        StudentDAO current = repo.delete(studentDAO);

        //assert
        Assertions.assertEquals(expected, current);

    }

    @Test
    @Rollback
    @DisplayName("delete Student - Not Found")
    void notFoundDeleteStudent() {
        //arrange
        StudentDAO studentDAO =  new StudentDAO("Pepe L", 5);

        //act
        StudentDAO current = repo.update(studentDAO);

        //assert
        Assertions.assertNull(current);

    }

    @Test
    @Rollback
    @DisplayName("delete Student - Not Found (null)")
    void notFoundNullDeleteStudent() {

        //act
        StudentDAO current = repo.delete(null);

        //assert
        Assertions.assertNull(current);

    }

    @Test
    @Rollback
    @DisplayName("get All")
    void getAll() {
        //arrange
        StudentDAO student1 = new StudentDAO("Carlos A", 1);
        StudentDAO student2 = new StudentDAO("Jose B", 2);
        StudentDAO student3 = new StudentDAO("Pablo C", 3);
        StudentDAO student4 = new StudentDAO("Pepe D", 4);

        List<StudentDAO> expected = new ArrayList<>();
        expected.add(student1);
        expected.add(student2);
        expected.add(student3);
        expected.add(student4);

        //act
        List<StudentDAO> current = repo.getAll();

        //assert
        Assertions.assertEquals(expected, current);

    }

}
