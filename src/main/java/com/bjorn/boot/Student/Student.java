package com.bjorn.boot.Student;

import com.bjorn.boot.School.School;
import com.bjorn.boot.StudentProfile;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

//Secondary Entity
@Entity
//entity use class name as table name
@Table(name = "Info")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @Column(
            unique = true
    )
    private String mail;

    private int age;

    //one to onr map with student to student profile
    @OneToOne(
            mappedBy = "student",
            cascade = CascadeType.ALL//used to update the changes that we done here in student profile even if we want to delete a student then their bio will be deleted automatically
    )
    private StudentProfile studentProfile;

    @ManyToOne
    @JoinColumn(
            name = "school_id"
    )
    @JsonBackReference//tells dont need to serialise here
    private School school;

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }



    public Student() {

    }

    public Student(String name, String mail, int age) {
        this.name = name;
        this.mail = mail;
        this.age = age;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
