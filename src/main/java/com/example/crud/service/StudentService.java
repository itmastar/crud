package com.example.crud.service;

import com.example.crud.model.StudentEntity;
import com.example.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<StudentEntity> getStudentById(int id){
        return repository.findById(id);
    }

    public StudentEntity updateStudent(StudentEntity updatedStudent,int id){
       Optional<StudentEntity> student=repository.findById(id);
       if(student.isPresent()){
           StudentEntity existingStudent=student.get();
           existingStudent.setEmail(updatedStudent.getEmail());
           repository.save(existingStudent);
           return existingStudent;

       }else{
           return null;
       }
    }

    public String deleteStudent(int id){
        repository.deleteById(id);
        return "Student record with id :"+id+" is deleted ";
    }
}
