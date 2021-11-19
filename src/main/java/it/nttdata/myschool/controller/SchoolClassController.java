package it.nttdata.myschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.nttdata.myschool.repository.SchoolClassRepository;

@Controller
public class SchoolClassController {

    private SchoolClassRepository schoolClassRepository;

    SchoolClassController(SchoolClassRepository schoolClassRepository){
        this.schoolClassRepository=schoolClassRepository;
    }

    @GetMapping("/classes")
    public String getScholClasses(Model model){
        model.addAttribute("schoolClasses", schoolClassRepository.findAll());
        return "schoolclass";  //ritorna una stringa con il nome della pagina html in templates

    }
    
}
