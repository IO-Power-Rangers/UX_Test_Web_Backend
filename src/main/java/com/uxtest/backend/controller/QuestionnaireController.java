package com.uxtest.backend.controller;

import com.uxtest.backend.dto.QuestionnaireDTO;
import com.uxtest.backend.model.Questionnaire;
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
    public void addQuestionnaire(@RequestBody QuestionnaireDTO questionnaireDTO) {

        // questionnaireService.addQuestionnaire(questionnaireDTO);

        System.out.println(questionnaireDTO.getName());
        questionnaireDTO.getQuestions().forEach(q ->  System.out.println(q.getContent()));
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
