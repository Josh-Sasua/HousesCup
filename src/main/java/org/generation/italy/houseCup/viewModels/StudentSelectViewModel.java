package org.generation.italy.houseCup.viewModels;

import org.generation.italy.houseCup.model.entities.Student;

public class StudentSelectViewModel {
    private long id;
    private String fullName;

    public StudentSelectViewModel() {
    }
    public StudentSelectViewModel(long id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }
    public static StudentSelectViewModel fromStudent(Student s){
        return new StudentSelectViewModel(s.getId(), s.getFirstname() + " " + s.getSurname());
    }
//    public StudentSelectViewModel toStudent(Student s){
//        return null; FORSE DA FARE
//    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
