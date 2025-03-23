package com.bjorn.boot.Student;

//to show not expose the full object to give only necessary infos
public record StudentResponseDto(
        String name,
        String mail
) {
}
