package it.nttdata.myschool.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.nttdata.myschool.entity.Student;
import it.nttdata.myschool.repository.StudentRepository;

@RestController
public class StudentRestController {

    private StudentRepository studentRepository;

    public StudentRestController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @GetMapping("/api/v0/students")
    public List<Student> getStudents(){

        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        
        return students;
    }

    @GetMapping("/api/v0/students/{id}")
    public Student getStudent(@PathVariable Long id){
        return studentRepository.findById(id).get();
    }
    
}
