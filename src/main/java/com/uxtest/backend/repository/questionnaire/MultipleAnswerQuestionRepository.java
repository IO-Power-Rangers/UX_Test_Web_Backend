package com.uxtest.backend.repository.questionnaire;

import com.uxtest.backend.model.questionnaire.question.MultipleAnswerQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultipleAnswerQuestionRepository extends JpaRepository<MultipleAnswerQuestion, Long> {
}
