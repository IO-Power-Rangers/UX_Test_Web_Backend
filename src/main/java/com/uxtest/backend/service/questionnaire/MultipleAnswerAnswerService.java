package com.uxtest.backend.service.questionnaire;

import com.uxtest.backend.dto.questionnaire.answer.MultipleAnswerAnswerDTO;
import com.uxtest.backend.dto.questionnaire.answer.MultipleChoiceAnswerDTO;
import com.uxtest.backend.model.questionnaire.answer.MultipleAnswerAnswer;
import com.uxtest.backend.model.questionnaire.answer.MultipleChoiceAnswer;
import com.uxtest.backend.repository.UserRepository;
import com.uxtest.backend.repository.questionnaire.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MultipleAnswerAnswerService {

    private final MultipleAnswerAnswerRepository multipleAnswerAnswerRepository;
    private final UserRepository userRepository;
    private final MultipleAnswerQuestionRepository multipleAnswerQuestionRepository;
    private final MultipleAnswerQuestionOptionRepository multipleAnswerQuestionOptionRepository;

    @Autowired
    public MultipleAnswerAnswerService(MultipleAnswerAnswerRepository multipleAnswerAnswerRepository,
                                       UserRepository userRepository,
                                       MultipleAnswerQuestionRepository multipleAnswerQuestionRepository,
                                       MultipleAnswerQuestionOptionRepository multipleAnswerQuestionOptionRepository) {

        this.multipleAnswerAnswerRepository = multipleAnswerAnswerRepository;
        this.userRepository = userRepository;
        this.multipleAnswerQuestionRepository = multipleAnswerQuestionRepository;
        this.multipleAnswerQuestionOptionRepository = multipleAnswerQuestionOptionRepository;
    }

    public void addMultipleAnswerAnswer(MultipleAnswerAnswerDTO multipleAnswerAnswerDTO) {

        // here or create parse method in MultipleAnswerAnswerDTO
        // resulting dependency to repository in DTO class?

        var user = userRepository.getOne(multipleAnswerAnswerDTO.getUserId());
        var question = multipleAnswerQuestionRepository.getOne(multipleAnswerAnswerDTO.getQuestionId());

        var selectedOptions = multipleAnswerAnswerDTO.getSelectedOptionsIds().stream()
                .map(multipleAnswerQuestionOptionRepository::getOne)
                .collect(Collectors.toList());

        MultipleAnswerAnswer multipleAnswerAnswer = MultipleAnswerAnswer.builder()
                .user(user)
                .question(question)
                .selectedOptions(selectedOptions)
                .build();

        multipleAnswerAnswerRepository.save(multipleAnswerAnswer);
    }
}


