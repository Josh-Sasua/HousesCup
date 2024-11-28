package org.generation.italy.houseCup.model.services;

import org.generation.italy.houseCup.model.entities.*;
import org.generation.italy.houseCup.model.exceptions.EntityNotFoundException;
import org.generation.italy.houseCup.model.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RegisterServiceJpa implements RegisterService{
    private CourseRepositoryJpa courseRepo;
    private HouseRepositoryJpa houseRepo;
    private StudentRepositoryJpa studentRepo;
    private TeacherRepositoryJpa teacherRepo;
    private ScoreRepositoryJpa scoreRepo;

    @Autowired
    public RegisterServiceJpa(CourseRepositoryJpa courseRepo, HouseRepositoryJpa houseRepo,
                              TeacherRepositoryJpa teacherRepo, StudentRepositoryJpa studentRepo, ScoreRepositoryJpa scoreRepo){
        this.courseRepo = courseRepo;
        this.houseRepo = houseRepo;
        this.studentRepo = studentRepo;
        this.teacherRepo = teacherRepo;
        this.scoreRepo = scoreRepo;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public List<Course> getAllActiveCourses() {
        return List.of();
    }

    @Override
    public List<House> getAllHouses() {
        return houseRepo.findAll();
    }

    @Override
    public Optional<Course> findCourseById(long id) {
        return courseRepo.findById(id);
    }

    @Override
    public Optional<House> findHouseById(long id) {
        return houseRepo.findById(id);
    }

    @Override
    public Student saveStudent(Student s) {
        return studentRepo.save(s);
    }

    @Override
    public Optional<Student> findStudentById(long id) {
        return studentRepo.findById(id);
    }

    @Override
    public List<Student> findStudentsByCourse(long courseId) {
        return studentRepo.findByCourseId(courseId);
    }

    @Override
    public Score saveScore(int score, String reason, long studentId, long teacherId) throws EntityNotFoundException {
        Optional<Student> os = studentRepo.findById(studentId);
        if (os.isEmpty()){
            throw new EntityNotFoundException("Lo studente con id: " + studentId + " non esiste brotherman.");
        }
        Optional<Teacher> ot = teacherRepo.findById(teacherId);
        if (ot.isEmpty()){
            throw new EntityNotFoundException("Il docente con id: " + teacherId + " non esiste broski.");
        }
        Score newScore = new Score(0, score, reason, LocalDate.now(), os.get(), ot.get());
        scoreRepo.save(newScore);
        return newScore;
    }
}