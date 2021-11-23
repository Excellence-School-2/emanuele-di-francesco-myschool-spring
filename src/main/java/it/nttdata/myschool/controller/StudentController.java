package it.nttdata.myschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.nttdata.myschool.entity.Student;
import it.nttdata.myschool.repository.SchoolClassRepository;
import it.nttdata.myschool.repository.StudentRepository;

@Controller
public class StudentController {

    private StudentRepository studentRepository;

    private SchoolClassRepository schoolClassRepository;

    public StudentController(StudentRepository studentRepository, SchoolClassRepository schoolClassRepository){
        this.studentRepository = studentRepository;
        this.schoolClassRepository = schoolClassRepository;
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

    @PostMapping("/addstudent")
    public String postNewStudent(Student student, @RequestParam String section){
        student.setSchoolClass(schoolClassRepository.findSchoolClassBySection(section));
        studentRepository.save(student);
        return "redirect:/students";

    }

     //Lo devo fare dopo il PostMapping per farci tornare il form --> devo mappare la richiesta get
     @GetMapping("/addstudent")
     public String getNewStudentForm(Model model) {
         model.addAttribute("sclasses", schoolClassRepository.findAll());
         return "addstudent";
 
     }
 
    
}
