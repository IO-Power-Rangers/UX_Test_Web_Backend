package com.uxtest.backend.service;

import com.uxtest.backend.model.db.questionnaire.Questionnaire;
import com.uxtest.backend.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionnaireService {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    public List<Questionnaire> getAllQuestionnaires() {
        List<Questionnaire> questionnaires = new ArrayList<>();
        questionnaireRepository.findAll()
            .forEach(questionnaires::add);

        return questionnaires;
    }

    public void addQuestionnaire(Questionnaire questionnaire) {
        questionnaireRepository.save(questionnaire);
    }

//    public Optional<Questionnaire> getQuestionnaireByName(String name) {
//
//        return questionnaireRepository.
//    }
}
