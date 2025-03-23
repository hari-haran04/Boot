package com.bjorn.boot.Student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//<Entity name, type of ID>
public interface StudentRepository extends JpaRepository<Student,Integer> {
    //to create custom filter instead of id
    List<Student> findAllByNameContaining(String p);
    //Containing refers to get all the name that contains the letter that we pass in the filter
}
