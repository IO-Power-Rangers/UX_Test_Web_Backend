package com.uxtest.backend.service.questionnaire;

import com.uxtest.backend.dto.questionnaire.answer.LikertScaleAnswerDTO;
import com.uxtest.backend.dto.questionnaire.answer.TextAnswerDTO;
import com.uxtest.backend.model.questionnaire.answer.LikertScaleAnswer;
import com.uxtest.backend.model.questionnaire.answer.TextAnswer;
import com.uxtest.backend.repository.questionnaire.LikertScaleAnswerRepository;
import com.uxtest.backend.repository.questionnaire.LikertScaleQuestionRepository;
import com.uxtest.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikertScaleAnswerService {

    private final LikertScaleAnswerRepository likertScaleAnswerRepository;
    private final UserRepository userRepository;
    private final LikertScaleQuestionRepository likertScaleQuestionRepository;

    @Autowired
    public LikertScaleAnswerService(LikertScaleAnswerRepository likertScaleAnswerRepository,
                                    UserRepository userRepository,
                                    LikertScaleQuestionRepository likertScaleQuestionRepository) {

        this.likertScaleAnswerRepository = likertScaleAnswerRepository;
        this.userRepository = userRepository;
        this.likertScaleQuestionRepository = likertScaleQuestionRepository;
    }

    public void addLikertScaleAnswer(LikertScaleAnswerDTO likertScaleAnswerDTO) {

        // here or create parse method in LikertScaleAnswerDTO
        // resulting dependency to repository in DTO class?

        var user = userRepository.getOne(likertScaleAnswerDTO.getUserId());
        var question = likertScaleQuestionRepository.getOne(likertScaleAnswerDTO.getQuestionId());

        LikertScaleAnswer likertScaleAnswer = LikertScaleAnswer.builder()
                .answer(likertScaleAnswerDTO.getAnswer())
                .user(user)
                .question(question)
                .build();

        likertScaleAnswerRepository.save(likertScaleAnswer);
    }
}
