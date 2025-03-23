package com.bjorn.boot.Student;

import com.bjorn.boot.School.School;
import jakarta.validation.constraints.Null;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student tostudent(StudentDto dto) throws NullPointerException{
        if(dto==null){
            throw new NullPointerException("Should not be null");
        }

        var student = new Student();
        student.setName(dto.name());
        student.setMail(dto.mail());

        var school = new School();
        school.setId(dto.school_id());

        student.setSchool(school);

        return student;
    }

    public StudentResponseDto tostudentResponseDto(Student student){
        return new StudentResponseDto(
                student.getName() ,
                student.getMail()
        );
    }

}
