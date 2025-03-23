package com.bjorn.boot.School;

import com.bjorn.boot.Student.Student;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Entity
public class School {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;


    @OneToMany(
            mappedBy = "school"
    )
    @JsonManagedReference //tells spring that school is parent of student so those data can be serialised in here
    private List<Student> student;


    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }


    public School() {
    }

    public School(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @RestController
    public static class SchoolController {

        private final SchoolService service;

        public SchoolController(SchoolService service) {
            this.service = service;
        }

        @PostMapping("/school")
        public SchoolDto create(
                @RequestBody School school
        ){


            return service.create(school);
        }


        @GetMapping("/schools")
        public List<SchoolDto> findall(){
            return service.findall();
        }

    }
}
