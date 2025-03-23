package com.bjorn.boot.Student;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/student")
    public StudentResponseDto savestudent(
            @Valid @RequestBody StudentDto dto
    ){
        return this.studentService.savestudent(dto);
    }

    //it shows error cos it should be a entity for that we need to convert it into school object


    @GetMapping("/students")
    public List<StudentResponseDto> getall(){
        return studentService.getall();
    }

    @GetMapping("/student/{id}")
    public StudentResponseDto getStudent(
            @PathVariable("id") Integer id
    ){
        return studentService.getStudent(id);//if it ocuurs it returns the object else it returns null
    }

    @GetMapping("/student/search/{name}")
    public List<StudentResponseDto> getsearch(
            @PathVariable("name") String name
    ){
        return studentService.getsearch(name);
    }

    @DeleteMapping("/student/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("id") Integer id
    ){
        studentService.delete(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleException(
            MethodArgumentNotValidException exp
    ){
        var errors = new HashMap<String,String>();
        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldname = ((FieldError) error).getField();
                    var errormessage = error.getDefaultMessage();
                    //System.out.println(errormessage);
                    errors.put(fieldname,errormessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

//    @PostMapping("/post-record")
//    public String post(
//            @RequestBody Inforec info
//    ){
//        return "Message: "+ info.toString();
//    }
//
//    @GetMapping("/hello/{user}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public String hello_wow(
//            @PathVariable("user") String naam
//    ){
//        return "Noothi pathu: "+ naam;
//    }
//
//    @GetMapping("/hello")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public String hello(
//            @RequestParam("user") String name,
//            @RequestParam("pass") int pass
//    ){
//        return "User = " + name + "\nPass = " + pass;
//    }
}
