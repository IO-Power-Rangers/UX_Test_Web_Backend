package com.uxtest.backend.model.survey;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("mock")
public class MockSurveyDB implements SurveyDB {

    private List<Survey> surveys;

    public MockSurveyDB() {
        surveys = new ArrayList<>();
    }

    @Override
    public void insertSurvey(Survey survey) {
        surveys.add(survey);
    }

    @Override
    public List<Survey> selectAllPeople() {
        return surveys;
    }

    @Override
    public Optional<Survey> selectSurveyByName(String name) {
        return surveys.stream()
                .filter(survey -> name.equals(survey.getName()))
                .findFirst();
    }
}
