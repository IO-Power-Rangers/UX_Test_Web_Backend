package com.uxtest.backend.service.questionnaire;

import com.uxtest.backend.dto.questionnaire.answer.TextAnswerDTO;
import com.uxtest.backend.model.questionnaire.answer.TextAnswer;
import com.uxtest.backend.repository.questionnaire.TextAnswerRepository;
import com.uxtest.backend.repository.questionnaire.TextQuestionRepository;
import com.uxtest.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TextAnswerService {

    private final TextAnswerRepository textAnswerRepository;
    private final UserRepository userRepository;
    private final TextQuestionRepository textQuestionRepository;

    @Autowired
    public TextAnswerService(TextAnswerRepository textAnswerRepository,
                             UserRepository userRepository,
                             TextQuestionRepository textQuestionRepository) {

        this.textAnswerRepository = textAnswerRepository;
        this.userRepository = userRepository;
        this.textQuestionRepository = textQuestionRepository;
    }

    public void addTextAnswer(TextAnswerDTO textAnswerDTO) {
        // here or create parse method in TextAnswerDTO
        // resulting dependency to repository in DTO class?

        var user = userRepository.getOne(textAnswerDTO.getUserId());
        var question = textQuestionRepository.getOne(textAnswerDTO.getQuestionId());

        TextAnswer textAnswer = TextAnswer.builder()
                .answer(textAnswerDTO.getAnswer())
                .user(user)
                .question(question)
                .build();

        textAnswerRepository.save(textAnswer);
    }
}
