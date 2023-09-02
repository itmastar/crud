package com.example.crud.service;

import com.example.crud.model.StudentEntity;
import com.example.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public String createStudent(StudentEntity student){
        repository.save(student);
        return "Record created with id :"+student.getId();
    }

    public List<StudentEntity> getStudents(){
        return repository.findAll();
    }
}
