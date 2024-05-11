package com.matt.example.Student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @InjectMocks //Inject our mocked objects into student service
    private StudentService studentService;

    //Declare dependencies

    @Mock //Mock these objects
    private StudentRepository repository;  //these need to be mocked

    @Mock //Mock these objects
    private StudentMapper studentMapper; //these need to be mocked

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_successfully_save_a_student() {
        //Given
        studentDTO dto = new studentDTO("john","doe","john@mail.com",1);

        Student student = new Student("john","doe","john@mail.com",20);

        Student savedStudent = new Student("john","doe","john@mail.com",20);

        savedStudent.setId(1);


        //Mock the calls used by this test
        Mockito.when(studentMapper.toStudent(dto))
                .thenReturn(student);
        Mockito.when(repository.save(student)).thenReturn(savedStudent);

        Mockito.when(studentMapper.TostudentResponseDTO(savedStudent)).thenReturn(new studentResponseDTO("john","doe","john@mail.com"));



        //When
        studentResponseDTO response = studentService.saveStudent(dto);

        //Then
        assertEquals((dto.firstname()), response.firstname());
        assertEquals(dto.lastname(), response.lastname());
        assertEquals(dto.email(), response.email());

        Mockito.verify(studentMapper, Mockito.times(1)).toStudent(dto); //Check toStudent has only been called once during the execution of the test
        Mockito.verify(repository, Mockito.times(1)).save(student); //Check save has only been called once during the execution of the test
        Mockito.verify(studentMapper, Mockito.times(1)).TostudentResponseDTO(savedStudent); //Check ToStudentResponseDTO has only been called once during the execution of the test



    }

    @Test
    public void should_return_all_students() {
        //Given
        List<Student> students = new ArrayList<>();
         students.add(new Student("john","doe","john@mail.com",20));
         //Mock Calls
         Mockito.when(repository.findAll()).thenReturn(students);
         Mockito.when(studentMapper.TostudentResponseDTO(ArgumentMatchers.any(Student.class))).thenReturn(new studentResponseDTO("john","doe","john@mail.com")); //Because we could pass any student use any()

         //When
        List<studentResponseDTO> findAllStudent = studentService.findAllStudent();

        //Then
        assertEquals(students.size(), findAllStudent.size());
        Mockito.verify(repository, Mockito.times(1)).findAll();

    }

    @Test
    public void should_return_student_with_id() {
        //Given
        int studentID = 1;
        Student student = new Student("john","doe","john@mail.com",20);
        studentResponseDTO dto = new studentResponseDTO("john","doe","john@mail.com");

        //Mock calls
        Mockito.when(repository.findById(studentID)).thenReturn(Optional.of(student));
        Mockito.when(studentMapper.TostudentResponseDTO(student)).thenReturn(dto);

        //When
       studentResponseDTO studentFound =  studentService.findStudentById(1);

       //then
        assertEquals(dto.firstname(), studentFound.firstname());
        assertEquals(dto.lastname(),studentFound.lastname());
        assertEquals(dto.email(),student.getEmail());
        Mockito.verify(repository, Mockito.times(1)).findById(studentID);
    }

    @Test
    public void findStudentByNameTest() {

        //Given
        String name = "john";
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("john","doe","john@mail.com",20));
        studentResponseDTO dto = new studentResponseDTO("john","doe","john@mail.com");

        //Mock calls

        Mockito.when(repository.findAllByFirstname(name)).thenReturn(studentList);
        Mockito.when(studentMapper.TostudentResponseDTO(Mockito.any(Student.class))).thenReturn(dto);

        //When

        List<studentResponseDTO> studentDTOs = studentService.findStudentByName("john");

        //Then
        System.out.println(studentDTOs.size());
        System.out.println(studentList.size());
        assertEquals(studentList.size(), studentDTOs.size());
        Mockito.verify(repository, Mockito.times(1)).findAllByFirstname(name);

    }
}