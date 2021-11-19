package it.nttdata.myschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import it.nttdata.myschool.repository.StudentRepository;

@Controller
public class StudentController {

    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public String getStudents(Model model){
        model.addAttribute("students",studentRepository.findAll());
        model.addAttribute("title", "Lista Studenti MySchool");
        return "studentlist";
    }

    @GetMapping("/students/{section}")
    public String getStudentsByClass(Model model, @PathVariable String section ){
        model.addAttribute("students", studentRepository.findStudentsByClass(section));
        model.addAttribute("title", "Lista Studenti " + section );
        return "studentlist";
    }
    
}
