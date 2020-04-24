package com.uxtest.backend.service;

import com.uxtest.backend.dto.QuestionnaireDTO;
import com.uxtest.backend.model.Question;
import com.uxtest.backend.model.Questionnaire;
import com.uxtest.backend.repository.QuestionRepository;
import com.uxtest.backend.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionnaireService(QuestionnaireRepository questionnaireRepository,
                                QuestionRepository questionRepository) {
        this.questionnaireRepository = questionnaireRepository;
        this.questionRepository = questionRepository;
    }

    public List<Questionnaire> getAllQuestionnaires() {

        return questionnaireRepository.findAll();


    }

    public void addQuestionnaire(Questionnaire questionnaire) {

        questionnaireRepository.save(questionnaire);

        for (var question : questionnaire.getQuestions()) {
            question.setQuestionnaire(questionnaire);
            questionRepository.save(question);
        }
    }

//    public Optional<Questionnaire> getQuestionnaireByName(String name) {
//
//        return questionnaireRepository.
//    }
}
