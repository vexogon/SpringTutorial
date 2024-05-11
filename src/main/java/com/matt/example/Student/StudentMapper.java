package com.matt.example.Student;

import com.matt.example.School.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toStudent(studentDTO dto) {
        if(dto == null) {
            throw new NullPointerException("The Student DTO should not be null");
        }
        var student = new Student(dto.firstname(), dto.lastname(),dto.email(), 0);
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());
        var school = new School();

        school.setId(dto.schoolId());

        student.setSchool(school);

        return student;
    }

    public studentResponseDTO TostudentResponseDTO(Student student) {
        return new studentResponseDTO(student.getFirstname(), student.getLastname(), student.getEmail());
    }
}
