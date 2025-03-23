package com.bjorn.boot.School;

import com.bjorn.boot.School.SchoolDto;
import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {

    public SchoolDto toSchooldto(School save) {
        return new SchoolDto(
                save.getName()
        );
    }

}
