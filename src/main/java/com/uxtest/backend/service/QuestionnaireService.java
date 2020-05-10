package com.uxtest.backend.service;

import com.uxtest.backend.model.questionnaire.Questionnaire;
import com.uxtest.backend.repository.MultipleChoiceQuestionOptionRepository;
import com.uxtest.backend.repository.MultipleChoiceQuestionRepository;
import com.uxtest.backend.repository.TextQuestionRepository;
import com.uxtest.backend.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;
    private final TextQuestionRepository questionRepository;
    private final MultipleChoiceQuestionRepository multipleChoiceQuestionRepository;
    private final MultipleChoiceQuestionOptionRepository multipleChoiceQuestionOptionRepository;

    @Autowired
    public QuestionnaireService(QuestionnaireRepository questionnaireRepository,
                                TextQuestionRepository questionRepository,
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

        saveTextQuestionsFromQuestionnaire(questionnaire);

        saveMultipleChoiceQuestionsWithOptionsFromQuestionnaire(questionnaire);
    }

    private void saveTextQuestionsFromQuestionnaire(Questionnaire questionnaire) {
        for (var question : questionnaire.getTextQuestions()) {
            question.setQuestionnaire(questionnaire);
            questionRepository.save(question);
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
}
