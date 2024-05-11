package com.matt.example.Student;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentMapperTest {

    @BeforeEach
    void setUp() {

        //Before each method is run, do this
        studentMapper = new StudentMapper();
    }

    private StudentMapper studentMapper;

    @Test
    public void shouldMapStudentDtoToStudentClass() {
        studentDTO dto = new studentDTO("john","doe","john@mail.com",1);

        Student student = studentMapper.toStudent(dto);

        //Test "mark scheme"
        Assertions.assertEquals(dto.firstname(), student.getFirstname());
        Assertions.assertEquals(dto.lastname(), student.getLastname());
        Assertions.assertEquals(dto.email(), student.getEmail());
        Assertions.assertNotNull(student.getSchool());
        Assertions.assertEquals(dto.schoolId(), student.getSchool().getId());


    }


    @Test
    public void TostudentResponseDTOTest() {
        Student student = new Student("matt","butler","mattbutler0001@gmail.com",19);
        studentResponseDTO response = studentMapper.TostudentResponseDTO(student);


        //Test "mark scheme"
        Assertions.assertEquals(response.firstname(), student.getFirstname());
        Assertions.assertEquals(response.lastname(), student.getLastname());
        Assertions.assertEquals(response.email(), student.getEmail());

    }

    @Test
    //Testing for exception handling
    public void should_throw_null_pointer_exception_when_student_dto_is_null() {
       var exp =  Assertions.assertThrows(NullPointerException.class, () -> studentMapper.toStudent(null)); //this exception should be thrown
        Assertions.assertEquals("The Student DTO should not be null", exp.getMessage());

    }

}