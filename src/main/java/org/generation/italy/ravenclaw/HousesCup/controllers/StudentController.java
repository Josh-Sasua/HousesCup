package org.generation.italy.ravenclaw.HousesCup.controllers;

import org.generation.italy.ravenclaw.HousesCup.models.entities.Student;
import org.generation.italy.ravenclaw.HousesCup.models.services.HousesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private HousesService housesService;
    @Autowired
    public StudentController(HousesService housesService) {
        this.housesService = housesService;
    }
    @GetMapping
    public String listOfStudents (Model model){
        List<Student> students = this.housesService.getAllStudents();
        model.addAttribute("STUDENTS", students);
        return "students/list";
    }
    @GetMapping("/create")
    public String createStudents (Model model){
        model.addAttribute("STUDENT", new Student());
        return "students/form";
    }
    @PostMapping
    public String saveStudents (@ModelAttribute("STUDENT") Student newStudent){
        this.housesService.save(newStudent);
        return "redirect:/students";
    }
}
