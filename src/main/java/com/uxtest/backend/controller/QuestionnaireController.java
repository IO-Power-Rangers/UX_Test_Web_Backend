package com.uxtest.backend.controller;

import com.uxtest.backend.dto.questionnaire.QuestionnaireDTO;
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

        //debugPrint(questionnaireDTO);

        questionnaireService.addQuestionnaire(questionnaireDTO.parseQuestionnaire());
    }

    @GetMapping
    public List<QuestionnaireDTO> getAllQuestionnaires() {

        return questionnaireService.getAllQuestionnaires().stream()
                .map(Questionnaire::mapToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public QuestionnaireDTO getQuestionnaireById(@PathVariable("id") Long id) {
        return questionnaireService.getQuestionnaireById(id).mapToDTO();
    }

    private void debugPrint(QuestionnaireDTO questionnaireDTO) {
        System.out.println(questionnaireDTO.getName());

        questionnaireDTO.getTextQuestions()
                .forEach(q -> System.out.println(q.getContent()));

        questionnaireDTO.getMultipleChoiceQuestions()
                .forEach(q -> {
                    System.out.println(q.getContent());
                    q.getOptions().forEach(o -> System.out.println(o.getContent()));
                });

        questionnaireDTO.getMultipleAnswerQuestions()
                .forEach(q -> {
                    System.out.println(q.getContent());
                    q.getOptions().forEach(o -> System.out.println(o.getContent()));
                });

        questionnaireDTO.getLikertScaleQuestions()
                .forEach(q -> {
                    System.out.println(q.getContent());
                    System.out.println(q.getPossibleStepsNo());
                });

    }
}
