package com.example.crud.controller;

import com.example.crud.model.StudentEntity;
import com.example.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping("/student")
    public String createStudent(@RequestBody StudentEntity student){
        service.createStudent(student);
        return "Record created with id :"+student.getId();
    }

    @GetMapping("/student")
    public List<StudentEntity>  getStudents(){
        return service.getStudents();
    }
    @GetMapping("/student/{id}")
    public Optional<StudentEntity> getStudentById(@PathVariable int id){
        return service.getStudentById(id);
    }

    @PutMapping("/student/{id}")
    public StudentEntity updateStudent(@RequestBody StudentEntity student , @PathVariable int id ){
        return service.updateStudent(student,id);

    }
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id){
        return service.deleteStudent(id);
    }
}
