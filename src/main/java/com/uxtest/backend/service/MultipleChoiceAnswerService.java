package com.uxtest.backend.service;

import com.uxtest.backend.model.questionnaire.answer.MultipleChoiceAnswer;
import com.uxtest.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultipleChoiceAnswerService {

    private final MultipleChoiceAnswerRepository multipleChoiceAnswerRepository;
    private final UserRepository userRepository;
    private final MultipleChoiceQuestionRepository multipleChoiceQuestionRepository;
    private final MultipleChoiceQuestionOptionRepository multipleChoiceQuestionOptionRepository;

    @Autowired
    public MultipleChoiceAnswerService(MultipleChoiceAnswerRepository multipleChoiceAnswerRepository,
                                       UserRepository userRepository,
                                       MultipleChoiceQuestionRepository multipleChoiceQuestionRepository,
                                       MultipleChoiceQuestionOptionRepository multipleChoiceQuestionOptionRepository) {

        this.multipleChoiceAnswerRepository = multipleChoiceAnswerRepository;
        this.userRepository = userRepository;
        this.multipleChoiceQuestionRepository = multipleChoiceQuestionRepository;
        this.multipleChoiceQuestionOptionRepository = multipleChoiceQuestionOptionRepository;
    }

    public void addMultipleChoiceAnswer(MultipleChoiceAnswer multipleChoiceAnswer) {

        var userId = multipleChoiceAnswer.getUser().getId();
        var questionId = multipleChoiceAnswer.getQuestion().getId();
        var selectedOptionId = multipleChoiceAnswer.getSelectedOption().getId();

        var user = userRepository.getOne(userId);
        var question = multipleChoiceQuestionRepository.getOne(questionId);
        var selectedOption = multipleChoiceQuestionOptionRepository.getOne(selectedOptionId);

        multipleChoiceAnswer.setUser(user);
        multipleChoiceAnswer.setQuestion(question);
        multipleChoiceAnswer.setSelectedOption(selectedOption);

        multipleChoiceAnswerRepository.save(multipleChoiceAnswer);
    }
}


