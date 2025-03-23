package com.bjorn.boot.Student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    private StudentMapper mapper;



    @Test
    public void shouldretuenstudentfromstudentdto(){
        StudentDto dto = new StudentDto("Natraj","natraj@gmail.com",2);

        Student stu = mapper.tostudent(dto);

        Assertions.assertEquals(stu.getName(),dto.name());
        Assertions.assertEquals(stu.getMail(),dto.mail());
        Assertions.assertNotNull(stu.getSchool());
        Assertions.assertEquals(stu.getSchool().getId(),dto.school_id());



    }

    @Test
    public void should_return_null_pointer_exception(){
        assertThrows(NullPointerException.class , ()-> {mapper.tostudent(null);});
    }

    @Test
    public void shouldreturnStudentdtofromstudent(){

        Student stu = new Student("Hari","hari@gmail.com",21);

        StudentResponseDto dto = mapper.tostudentResponseDto(stu);

        assertEquals(dto.name(),stu.getName());
        assertEquals(dto.mail(),stu.getMail());



    }

}