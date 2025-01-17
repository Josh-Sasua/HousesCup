package org.generation.italy.houseCup.model.services;

import org.generation.italy.houseCup.model.entities.Course;
import org.generation.italy.houseCup.model.entities.House;
import org.generation.italy.houseCup.model.entities.Score;
import org.generation.italy.houseCup.model.entities.Student;
import org.generation.italy.houseCup.model.exceptions.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public interface RegisterService{

    List<Course> getAllCourses();
    List<Course> getAllActiveCourses();
    List<House> getAllHouses();
    Optional<Course> findCourseById(long id);
    Optional<House> findHouseById(long id);
    Student saveStudent(Student s);
    Optional<Student> findStudentById(long id);
    List<Student> findStudentsByCourse(long courseId);
    Score saveScore(int score, String reason, long studentId, long teacherId) throws EntityNotFoundException;
}
