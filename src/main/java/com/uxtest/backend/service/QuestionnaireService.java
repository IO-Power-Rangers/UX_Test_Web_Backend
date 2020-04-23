package com.uxtest.backend.service;

import com.uxtest.backend.dto.QuestionnaireDTO;
import com.uxtest.backend.model.Questionnaire;
import com.uxtest.backend.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;

    @Autowired
    public QuestionnaireService(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    public List<Questionnaire> getAllQuestionnaires() {

        return questionnaireRepository.findAll();


    }

    public void addQuestionnaire(Questionnaire questionnaire) {

        questionnaireRepository.save(questionnaire);
    }

//    public Optional<Questionnaire> getQuestionnaireByName(String name) {
//
//        return questionnaireRepository.
//    }
}
