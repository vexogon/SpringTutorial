package com.matt.example.Student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.matt.example.School.School;
import com.matt.example.StudentProfile.StudentProfile;
import jakarta.persistence.*;

@Entity
@Table(name = "t_student")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(
            name = "c_fname",
            length = 20
    )
    private String firstname;
    private String lastname;



    @Column(unique = true)
    private String email;
    private int age;

    @ManyToOne
    @JoinColumn(
            name = "school_id"
    )
    @JsonBackReference
    private School school;

    @OneToOne(mappedBy = "student",
    cascade = CascadeType.ALL) //Cascade ='s what happens on delete
    private StudentProfile studentProfile; //One to one relationship

    public Student(String firstname, String lastname, String email, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;

    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }
}
