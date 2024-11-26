package org.generation.italy.ravenclaw.HousesCup.models.services;

import org.generation.italy.ravenclaw.HousesCup.models.entities.Student;

import java.util.List;

public interface HousesService {
    List<Student> getAllStudents();
    Student addStudente(Student newStudente);
}
