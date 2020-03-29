package com.uxtest.backend.model.survey;

import java.util.List;
import java.util.Optional;

public interface SurveyDB {
    void insertSurvey(Survey survey);
    List<Survey> selectAllPeople();
    Optional<Survey> selectSurveyByName(String name);
}
