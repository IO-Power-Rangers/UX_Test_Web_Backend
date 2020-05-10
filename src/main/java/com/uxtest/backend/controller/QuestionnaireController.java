package com.uxtest.backend.controller;

import com.uxtest.backend.dto.QuestionnaireDTO;
import com.uxtest.backend.model.questionnaire.Questionnaire;
import com.uxtest.backend.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

        questionnaireService.addQuestionnaire(questionnaireDTO.parseQuestionnaire());
    }

    @GetMapping
    public List<QuestionnaireDTO> getAllQuestionnaires() {

        return questionnaireService.getAllQuestionnaires().stream()
                .map(Questionnaire::mapToDTO)
                .collect(Collectors.toList());
    }
}
