package com.matt.example.StudentProfile;


import com.matt.example.Student.Student;
import jakarta.persistence.*;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue
    private String id;
    private String bio;

    @OneToOne
    @JoinColumn(
            name = "student_id"
    )
    private Student student; //mapped by will look for this

    public StudentProfile(String bio) {
        this.bio = bio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
