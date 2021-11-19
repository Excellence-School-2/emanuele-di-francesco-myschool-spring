package it.nttdata.myschool.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.nttdata.myschool.entity.SchoolClass;
import it.nttdata.myschool.entity.Student;
import it.nttdata.myschool.repository.SchoolClassRepository;
import it.nttdata.myschool.repository.StudentRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    // Dipendenze
    private final StudentRepository studentRepository;
    private final SchoolClassRepository schoolClassRepository;

    public BootstrapData(StudentRepository studentRepository, SchoolClassRepository schoolClassRepository){
        this.studentRepository = studentRepository;
        this.schoolClassRepository = schoolClassRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        // Creo le sezioni
        
        SchoolClass schoolClass1 = new SchoolClass("1A");
        SchoolClass schoolClass2 = new SchoolClass("2A");
        SchoolClass schoolClass3 = new SchoolClass("3A");

        // Creo gli studenti

        Student student1 = new Student("Mario","Rossi",14);
        Student student2 = new Student("Giulio","Bianchi",14);
        Student student3 = new Student("Anna","Gialli",15);
        Student student4 = new Student("Carlo","Cracco",15);
        Student student5 = new Student("Joe","Bastianich",16);
        Student student6 = new Student("Bruno","Barbieri",16);

        // Assegno gli studenti alle sezioni 

        student1.setSchoolClass(schoolClass1);
        student2.setSchoolClass(schoolClass1);
        student3.setSchoolClass(schoolClass2);
        student4.setSchoolClass(schoolClass2);
        student5.setSchoolClass(schoolClass3);
        student6.setSchoolClass(schoolClass3);

        // Salvo le sezioni nella Repository (si salva prima la classe più forte OneToMany)

        schoolClassRepository.save(schoolClass1);
        schoolClassRepository.save(schoolClass2);
        schoolClassRepository.save(schoolClass3);

        // Salvo gli studenti nella Repository (si salva dopo la classe dipendente ManyToOne)

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);
        studentRepository.save(student5);
        studentRepository.save(student6);
        
        
    }
    
}
