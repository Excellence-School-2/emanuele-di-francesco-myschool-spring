package it.nttdata.myschool.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.nttdata.myschool.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

    // QUery in formato JPA
    @Query(" SELECT s FROM Student s WHERE s.schoolClass.section = :section ")
    public Collection<Student> findStudentsByClass(@Param("section") String section);
}
