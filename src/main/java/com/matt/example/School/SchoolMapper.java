package com.matt.example.School;

import com.matt.example.School.School;
import com.matt.example.School.schoolDTO;
import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {

    public School toSchool(schoolDTO dto) {
        School school = new School();
        school.setName(dto.name());
        return school;
    }

    public schoolDTO toSchoolDTO(School school) {
        return new schoolDTO(school.getName());
    }

}
