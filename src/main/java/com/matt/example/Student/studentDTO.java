package com.matt.example.Student;

import jakarta.validation.constraints.NotEmpty;

public record studentDTO(
        @NotEmpty(message = "Firstname should not be empty")
        String firstname,

        @NotEmpty (message = "last name shouldn't be empty")
        String lastname,
        String email,

        Integer schoolId
) {
}
