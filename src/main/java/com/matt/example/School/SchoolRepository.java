package com.matt.example.School;

import com.matt.example.School.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {

}
