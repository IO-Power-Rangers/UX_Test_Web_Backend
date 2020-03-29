package com.uxtest.backend.service;

import com.uxtest.backend.model.survey.Survey;
import com.uxtest.backend.model.survey.SurveyDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {

    private final SurveyDB db;

    @Autowired
    public SurveyService(@Qualifier("mock") SurveyDB surveyDB) {
        db = surveyDB;
    }

    public void addSurvey(Survey survey) {
        db.insertSurvey(survey);
    }

    public void addSurveys(List<Survey> surveys)
    {
        surveys.forEach(db::insertSurvey);
    }

    public List<Survey> getAllSurveys() {
        return db.selectAllPeople();
    }

    public Optional<Survey> getSurveyByName(String name) {
        return db.selectSurveyByName(name);
    }

}
