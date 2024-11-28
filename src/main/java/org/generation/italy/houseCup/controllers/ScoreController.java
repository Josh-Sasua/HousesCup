package org.generation.italy.houseCup.controllers;

import org.generation.italy.houseCup.model.entities.Course;
import org.generation.italy.houseCup.model.entities.Score;
import org.generation.italy.houseCup.model.entities.Student;
import org.generation.italy.houseCup.model.exceptions.EntityNotFoundException;
import org.generation.italy.houseCup.model.services.RegisterService;
import org.generation.italy.houseCup.viewModels.ChooseClassViewModel;
import org.generation.italy.houseCup.viewModels.CourseSelectViewModel;
import org.generation.italy.houseCup.viewModels.CreateScoreViewModel;
import org.generation.italy.houseCup.viewModels.StudentSelectViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/score") // specifica la route per la visualizzazione dei punti di un studente specifico (points/{id})
public class ScoreController {
    private RegisterService registerService;
    @Autowired
    public ScoreController(RegisterService registerService){
        this.registerService = registerService;
    }
    @GetMapping("/classSelectionForm")
    public String showClassSelectionForm(Model model){
        List<Course> courses = registerService.getAllCourses();
        List<CourseSelectViewModel> coursesVm = courses.stream()
                .map(CourseSelectViewModel::fromCourse).toList();
        ChooseClassViewModel classModel = new ChooseClassViewModel(0,coursesVm);
        model.addAttribute("courseSelector",classModel);
        return "/score/selectClassForm";
    }
    @GetMapping("/create")
    public String showCreateScoreForm(Model model, ChooseClassViewModel chooseClassViewModel){
        long courseId = chooseClassViewModel.getCourseId();
        List<Student> enrolledStudents = this.registerService.findStudentsByCourse(courseId);
        CreateScoreViewModel scoreViewModel = new CreateScoreViewModel();
        List<StudentSelectViewModel> studentOptions = enrolledStudents.stream()
                .map(StudentSelectViewModel::fromStudent).toList();
        scoreViewModel.setStudentOptions(studentOptions);
        model.addAttribute("scoreModel", scoreViewModel);
        return "/score/addScore";
    }
    @PostMapping("/create")
    public String saveScore(CreateScoreViewModel createScoreViewModel){
        long teacherId = 1; //createScoreViewModel.getTeacherId(); in caso fosse vero
        long studentId = createScoreViewModel.getStudentId();
        String reason = createScoreViewModel.getReason();
        int score = createScoreViewModel.getScore();
        //MODO UNO POTREI CARICARMI LO STUDENT E IL TEACHER ASSOCIATI AGLI ID
        //MODO DUE INVOCO UN METODO PASSANDOGLI GLI ID E FA TUTTO LUI
        try {
            Score saved = registerService.saveScore(score, reason, studentId, teacherId);
            return "redirect:/score/houseStanding";
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
            return "/score/error";
        }
    }
    @GetMapping("/houseStanding")
    public String showHouseStanding(Model model){
        model.addAttribute("gryffindorScore", 100);
        model.addAttribute("hufflepuffScore", -100);
        model.addAttribute("slytherinScore", 35);
        model.addAttribute("rocketclawScore", 1000);
        model.addAttribute("winner", "rocketclaw");

        return "/score/houseStanding";
    }
}
