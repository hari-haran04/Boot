package com.bjorn.boot.School;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private final SchoolMapper schoolMapper;

    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolMapper schoolMapper, SchoolRepository schoolRepository) {
        this.schoolMapper = schoolMapper;
        this.schoolRepository = schoolRepository;
    }

    public SchoolDto create(
            @RequestBody School school
    ){

        var save = schoolRepository.save(school);
        return schoolMapper.toSchooldto(save);
    }

    public List<SchoolDto> findall(){
        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::toSchooldto)
                .collect(Collectors.toList());
    }

}
