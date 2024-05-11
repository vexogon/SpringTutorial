package com.matt.example.Student;


import com.matt.example.Student.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository repository;

    private final StudentMapper studentMapper;

    @Autowired
    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }
    public studentResponseDTO saveStudent(studentDTO student) {
        Student dto = studentMapper.toStudent(student);
        Student savedStudent = repository.save(dto); //Uses studentDTO (reduced input)
        return studentMapper.TostudentResponseDTO(savedStudent); //response with studentResponseDTO (reduced output
    }

    public List<studentResponseDTO> findAllStudent() {
        return this.repository.findAll().stream().map(studentMapper::TostudentResponseDTO).collect(Collectors.toList());
    }
    public studentResponseDTO findStudentById(int id) {
        return repository.findById(id).map(studentMapper::TostudentResponseDTO).orElse(null);

        //Any Optional Type in java can be transformed into a map and sent to a method for transforming.
    }
    public List<studentResponseDTO> findStudentByName(String name) {
       return  this.repository.findAllByFirstname(name).stream().map(studentMapper::TostudentResponseDTO).collect(Collectors.toList());
    }
    public void delete(int studentId) {
        repository.deleteById(studentId);
        return;
    }
}
