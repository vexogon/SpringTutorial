package com.matt.example.School;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolRepository schoolRepository;

    private final SchoolService schoolService;



    @Autowired
    public SchoolController(SchoolRepository schoolRepository, SchoolService schoolService) {
        this.schoolService = schoolService;
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public schoolDTO create ( @RequestBody schoolDTO school) {
        this.schoolService.create(school);
        return school;

    }


    @GetMapping("/schools")
    public List<schoolDTO> findAll () {
        return this.schoolService.findAll();

    }


}
