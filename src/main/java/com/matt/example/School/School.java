package com.matt.example.School;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.matt.example.Student.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class School {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @OneToMany(
            mappedBy = "school"
    )
    @JsonManagedReference //Basically tells School to manage serializing the child and not to allow child to serialize parent
    private List<Student> students;


    public School() {
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
