package org.generation.italy.ravenclaw.HousesCup.models.repositories;
import org.generation.italy.ravenclaw.HousesCup.models.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositoryJPA extends JpaRepository<Student, Long> {
    // Costruttore di default
}
