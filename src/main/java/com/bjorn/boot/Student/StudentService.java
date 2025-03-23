package com.bjorn.boot.Student;

import com.bjorn.boot.Student.StudentDto;
import com.bjorn.boot.Student.StudentMapper;
import com.bjorn.boot.Student.StudentRepository;
import com.bjorn.boot.Student.StudentResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository repository;
    private final StudentMapper mapper;

    public StudentService(StudentRepository repository, StudentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public StudentResponseDto savestudent(
            StudentDto dto
    ){
        var student = mapper.tostudent(dto);
        var saved = repository.save(student);
        return mapper.tostudentResponseDto(saved);
    }

    public List<StudentResponseDto> getall()
    {
        return repository.findAll()
                .stream()
                .map(mapper::tostudentResponseDto)
                .collect(Collectors.toList());
    }

    public StudentResponseDto getStudent(
            Integer id
    ){
        var Student = repository.findById(id).orElse(null);
        return mapper.tostudentResponseDto(Student);
    }

    public List<StudentResponseDto> getsearch(
            String name
    ){
        return repository.findAllByNameContaining(name)
                .stream()
                .map(mapper::tostudentResponseDto)
                .collect(Collectors.toList());
    }

    public void delete(
             Integer id
    ){
        repository.deleteById(id);
    }

}
