package com.bjorn.boot.Student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(

        //@NotEmpty
        @NotEmpty(message = "not be empty")
        String name,
        String mail,
        Integer school_id

) {
}
