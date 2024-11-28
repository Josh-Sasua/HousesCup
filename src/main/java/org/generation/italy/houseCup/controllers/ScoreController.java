package org.generation.italy.houseCup.controllers;

import org.generation.italy.houseCup.model.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/score") // specifica la route per la visualizzazione dei punti di un studente specifico (points/{id})
public class ScoreController {
    private RegisterService registerService;
    @Autowired
    public ScoreController(RegisterService registerService){
        this.registerService = registerService;
    }
    @GetMapping("/points/{id}")
    public String updatePoints (@PathVariable ) {
        //PRENDERE UNA LIST DI STUDENTS (NON ESISTE) E HAVE DUE BUTTON PER ADDARE O DELETARE POINTS ALL'HOUSES A CUI APPARTENGONO
        //SUPER CRUNCHY
        return null;
    }
}
