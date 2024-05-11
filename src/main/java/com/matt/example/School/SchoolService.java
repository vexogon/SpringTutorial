package com.matt.example.School;

import com.matt.example.School.School;
import com.matt.example.School.SchoolMapper;
import com.matt.example.School.SchoolRepository;
import com.matt.example.School.schoolDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private final SchoolMapper schoolMapper;

    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolService(SchoolMapper schoolMapper, SchoolRepository schoolRepository) {
        this.schoolMapper = schoolMapper;
        this.schoolRepository = schoolRepository;
    }


    public schoolDTO create(schoolDTO schoolDTO) {

        School schoolfromDTO = this.schoolMapper.toSchool(schoolDTO);
        School savedSchool = schoolRepository.save(schoolfromDTO);
        return schoolDTO;
    }

    public List<schoolDTO> findAll() {
        return schoolRepository.findAll().stream()
                .map(schoolMapper::toSchoolDTO).collect(Collectors.toList());
    }
        /* Steam -  in java converts a list of items to be processed one at a time
        .Map(this::toSchoolDTO) - applies schoolDTO to each of the items in the map
        .Collect puts the results of this back into a list
         */

}
