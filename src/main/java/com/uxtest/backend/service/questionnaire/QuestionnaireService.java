package com.uxtest.backend.service.questionnaire;

import com.uxtest.backend.dto.questionnaire.QuestionnaireDTO;
import com.uxtest.backend.model.questionnaire.Questionnaire;
import com.uxtest.backend.model.questionnaire.question.Question;
import com.uxtest.backend.repository.TestRepository;
import com.uxtest.backend.repository.questionnaire.*;
import com.uxtest.backend.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;
    private final TextQuestionRepository textQuestionRepository;
    private final MultipleChoiceQuestionRepository multipleChoiceQuestionRepository;
    private final MultipleChoiceQuestionOptionRepository multipleChoiceQuestionOptionRepository;
    private final MultipleAnswerQuestionRepository multipleAnswerQuestionRepository;
    private final MultipleAnswerQuestionOptionRepository multipleAnswerQuestionOptionRepository;
    private final LikertScaleQuestionRepository likertScaleQuestionRepository;

    private final TestService testService;

    @Autowired
    public QuestionnaireService(QuestionnaireRepository questionnaireRepository,
                                TextQuestionRepository textQuestionRepository,
                                MultipleChoiceQuestionRepository multipleChoiceQuestionRepository,
                                MultipleChoiceQuestionOptionRepository multipleChoiceQuestionOptionRepository,
                                MultipleAnswerQuestionRepository multipleAnswerQuestionRepository,
                                MultipleAnswerQuestionOptionRepository multipleAnswerQuestionOptionRepository,
                                LikertScaleQuestionRepository likertScaleQuestionRepository,
                                TestService testService) {

        this.questionnaireRepository = questionnaireRepository;
        this.textQuestionRepository = textQuestionRepository;
        this.multipleChoiceQuestionRepository = multipleChoiceQuestionRepository;
        this.multipleChoiceQuestionOptionRepository = multipleChoiceQuestionOptionRepository;
        this.multipleAnswerQuestionRepository = multipleAnswerQuestionRepository;
        this.multipleAnswerQuestionOptionRepository = multipleAnswerQuestionOptionRepository;
        this.likertScaleQuestionRepository = likertScaleQuestionRepository;
        this.testService = testService;
    }

    public List<Questionnaire> getAllQuestionnaires() {

        return questionnaireRepository.findAll();
    }

    public void addQuestionnaire(QuestionnaireDTO questionnaireDTO) {

        var test = testService.getTestById(questionnaireDTO.getTestId());

        var questionnaire = questionnaireDTO.parseQuestionnaire();

        questionnaire.setTest(test);

        questionnaireRepository.save(questionnaire);

        saveTextQuestionsFromQuestionnaire(questionnaire);
        saveMultipleChoiceQuestionsWithOptionsFromQuestionnaire(questionnaire);
        saveMultipleAnswerQuestionsWithOptionsFromQuestionnaire(questionnaire);
        saveLikertScaleQuestionsFromQuestionnaire(questionnaire);
    }

    public Questionnaire getQuestionnaireById(Long id) {
        return questionnaireRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Questionnaire not found"));
    }

    public List<Question> getQuestionsByQuestionnaireId(Long id) {
        Questionnaire questionnaire = questionnaireRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Questionnaire not found"));
        List<Question> result = new ArrayList<>();
        result.addAll(questionnaire.getTextQuestions());
        result.addAll(questionnaire.getMultipleChoiceQuestions());
        result.addAll(questionnaire.getMultipleAnswerQuestions());
        result.addAll(questionnaire.getLikertScaleQuestions());
        return result;

    }

    private void saveTextQuestionsFromQuestionnaire(Questionnaire questionnaire) {
        for (var question : questionnaire.getTextQuestions()) {
            question.setQuestionnaire(questionnaire);
            textQuestionRepository.save(question);
        }
    }

    private void saveMultipleChoiceQuestionsWithOptionsFromQuestionnaire(Questionnaire questionnaire) {
        for (var question : questionnaire.getMultipleChoiceQuestions()) {
            question.setQuestionnaire(questionnaire);
            multipleChoiceQuestionRepository.save(question);

            for (var option : question.getOptions()) {
                option.setMultipleChoiceQuestion(question);
                multipleChoiceQuestionOptionRepository.save(option);
            }
        }
    }

    private void saveMultipleAnswerQuestionsWithOptionsFromQuestionnaire(Questionnaire questionnaire) {
        for (var question : questionnaire.getMultipleAnswerQuestions()) {
            question.setQuestionnaire(questionnaire);
            multipleAnswerQuestionRepository.save(question);

            for (var option : question.getOptions()) {
                option.setMultipleAnswerQuestion(question);
                multipleAnswerQuestionOptionRepository.save(option);
            }
        }
    }

    private void saveLikertScaleQuestionsFromQuestionnaire(Questionnaire questionnaire) {
        for (var question : questionnaire.getLikertScaleQuestions()) {
            question.setQuestionnaire(questionnaire);
            likertScaleQuestionRepository.save(question);
        }
    }

}
