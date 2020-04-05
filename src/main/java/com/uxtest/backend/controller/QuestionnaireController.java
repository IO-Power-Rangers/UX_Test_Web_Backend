package com.uxtest.backend.controller;

import com.uxtest.backend.model.questionnaire.Questionnaire;
import com.uxtest.backend.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/questionnaire")
@RestController
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;

    @Autowired
    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @PostMapping
    public void addQuestionnaire(@RequestBody Questionnaire questionnaire) {

        questionnaireService.addQuestionaire(questionnaire);
    }

    @GetMapping
    public List<Questionnaire> getAllQuestionnaires() {

        return questionnaireService.getAllQuestionnaires();
    }

//    @GetMapping("/byname")
//    public Questionnaire getSurveyByName(@RequestParam String name) {
//        return questionnaireService.getQuestionnaireByName(name).orElse(null);
//    }

}
