package com.uxtest.backend.service;

import com.uxtest.backend.model.questionnaire.answer.TextAnswer;
import com.uxtest.backend.model.questionnaire.question.TextQuestion;
import com.uxtest.backend.repository.TextAnswerRepository;
import com.uxtest.backend.repository.TextQuestionRepository;
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

    public void addTextAnswer(TextAnswer textAnswer) {

        var userId = textAnswer.getUser().getId();
        var questionId = textAnswer.getQuestion().getId();

        var user = userRepository.getOne(userId);
        var question = textQuestionRepository.getOne(questionId);

        textAnswer.setUser(user);
        textAnswer.setQuestion(question);

        textAnswerRepository.save(textAnswer);
    }
}
