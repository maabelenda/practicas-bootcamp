package com.example.demojpa.services;

import com.example.demojpa.model.Student;
import com.example.demojpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImp implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.getById(id);
    }
}
