package com.matt.example.Student;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }

    @PostMapping("/students")
    public studentResponseDTO saveStudent(@Valid @RequestBody studentDTO student) { //
        return this.studentService.saveStudent(student);
    }


    @GetMapping("/students")
    public List<studentResponseDTO> findAllStudent() {
        return this.studentService.findAllStudent();
    }
    @GetMapping("/students/{student-id}")
    public studentResponseDTO findStudentById(@PathVariable("student-id") int studentId) {
        return this.studentService.findStudentById(studentId);
    }
    @GetMapping("/students/search/{student-name}")
    public List<studentResponseDTO> findStudentByName(@PathVariable("student-name") String studentName) {
        //Student[] students = {};
        return this.studentService.findStudentByName(studentName);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK) //Sets response code
    public void delete(@PathVariable("student-id") int studentId) {
        this.studentService.delete(studentId);
        return;
    }

    @ExceptionHandler
    //Every time this exception is thrown, this code will be called
    public ResponseEntity<?> MethodArgumentNotValidException( //Question Mark means of return a RespnosEntity of any type
                                                              MethodArgumentNotValidException exp
    ) {
        HashMap<String, String> errors = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors().forEach(error -> {
            var fieldName = ((FieldError) error).getField();
            var errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
