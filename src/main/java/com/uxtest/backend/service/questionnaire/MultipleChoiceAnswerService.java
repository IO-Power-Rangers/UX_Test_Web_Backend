package com.uxtest.backend.service.questionnaire;

import com.uxtest.backend.dto.questionnaire.answer.MultipleChoiceAnswerDTO;
import com.uxtest.backend.model.questionnaire.answer.MultipleChoiceAnswer;
import com.uxtest.backend.model.questionnaire.question.MultipleChoiceQuestion;
import com.uxtest.backend.repository.*;
import com.uxtest.backend.repository.questionnaire.MultipleChoiceAnswerRepository;
import com.uxtest.backend.repository.questionnaire.MultipleChoiceQuestionOptionRepository;
import com.uxtest.backend.repository.questionnaire.MultipleChoiceQuestionRepository;
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

    public void addMultipleChoiceAnswer(MultipleChoiceAnswerDTO multipleChoiceAnswerDTO) {

        // here or create parse method in MultipleChoiceAnswerDTO
        // resulting dependency to repository in DTO class?

        var user = userRepository.getOne(multipleChoiceAnswerDTO.getUserId());
        var question = multipleChoiceQuestionRepository.getOne(multipleChoiceAnswerDTO.getQuestionId());
        var selectedOption = multipleChoiceQuestionOptionRepository.getOne(multipleChoiceAnswerDTO.getSelectedOptionId());

        MultipleChoiceAnswer multipleChoiceAnswer = MultipleChoiceAnswer.builder()
                .user(user)
                .question(question)
                .selectedOption(selectedOption)
                .build();

        multipleChoiceAnswerRepository.save(multipleChoiceAnswer);
    }
}


