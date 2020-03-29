package com.uxtest.backend.api;

import com.uxtest.backend.model.survey.Survey;
import com.uxtest.backend.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1/survey")
@RestController
public class SurveyController {

    private final SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {

        this.surveyService = surveyService;
    }

    @PostMapping
    public void addSurvey(@RequestBody Survey survey) {
        surveyService.addSurvey(survey);
    }

    @PostMapping("addMany")
    public void addSurveys(@RequestBody List<Survey> surveys) {
        surveyService.addSurveys(surveys);
    }
    @GetMapping
    public List<Survey> getAllSurveys() {
        return surveyService.getAllSurveys();
    }

    @GetMapping("/byname")
    public Survey getSurveyByName(@RequestParam String name) {
        return surveyService.getSurveyByName(name).orElse(null);
    }

}
