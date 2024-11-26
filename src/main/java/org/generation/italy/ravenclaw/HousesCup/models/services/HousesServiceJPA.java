package org.generation.italy.ravenclaw.HousesCup.models.services;

import org.generation.italy.ravenclaw.HousesCup.models.entities.Student;
import org.generation.italy.ravenclaw.HousesCup.models.repositories.StudentRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HousesServiceJPA implements HousesService{
    private StudentRepositoryJPA studentRepo;
    @Autowired
    public HousesServiceJPA(StudentRepositoryJPA studentRepo) {
        this.studentRepo = studentRepo;
    }


    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student addStudente(Student newStudente) {
        return null;
    }
}
