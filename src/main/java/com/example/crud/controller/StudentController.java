package com.example.crud.controller;

import com.example.crud.model.StudentEntity;
import com.example.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
