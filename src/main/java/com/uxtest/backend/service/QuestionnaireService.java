package com.uxtest.backend.service;

import com.uxtest.backend.model.questionnaire.MultipleChoiceQuestion;
import com.uxtest.backend.model.questionnaire.Questionnaire;
import com.uxtest.backend.repository.MultipleChoiceQuestionOptionRepository;
import com.uxtest.backend.repository.MultipleChoiceQuestionRepository;
import com.uxtest.backend.repository.QuestionRepository;
import com.uxtest.backend.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;
    private final QuestionRepository questionRepository;
    private final MultipleChoiceQuestionRepository multipleChoiceQuestionRepository;
    private final MultipleChoiceQuestionOptionRepository multipleChoiceQuestionOptionRepository;

    @Autowired
    public QuestionnaireService(QuestionnaireRepository questionnaireRepository,
                                QuestionRepository questionRepository,
                                MultipleChoiceQuestionRepository multipleChoiceQuestionRepository,
                                MultipleChoiceQuestionOptionRepository multipleChoiceQuestionOptionRepository) {
        this.questionnaireRepository = questionnaireRepository;
        this.questionRepository = questionRepository;
        this.multipleChoiceQuestionRepository = multipleChoiceQuestionRepository;
        this.multipleChoiceQuestionOptionRepository = multipleChoiceQuestionOptionRepository;
    }

    public List<Questionnaire> getAllQuestionnaires() {

        return questionnaireRepository.findAll();
    }

    public void addQuestionnaire(Questionnaire questionnaire) {

        questionnaireRepository.save(questionnaire);

        saveTextQuestions(questionnaire);

        saveMultipleChoiceQuestions(questionnaire);
    }

    private void saveTextQuestions(Questionnaire questionnaire) {
        for (var question : questionnaire.getTextQuestions()) {
            question.setQuestionnaire(questionnaire);
            questionRepository.save(question);
        }
    }

    private void saveMultipleChoiceQuestions(Questionnaire questionnaire) {
        for (var question : questionnaire.getMultipleChoiceQuestions()) {
            question.setQuestionnaire(questionnaire);
            multipleChoiceQuestionRepository.save(question);

            for (var option : question.getOptions()) {
                option.setQuestion(question);
                multipleChoiceQuestionOptionRepository.save(option);
            }
        }
    }
}
