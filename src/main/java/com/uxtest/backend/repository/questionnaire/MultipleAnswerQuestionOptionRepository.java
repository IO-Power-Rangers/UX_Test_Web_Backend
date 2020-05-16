package com.uxtest.backend.repository.questionnaire;

import com.uxtest.backend.model.questionnaire.question.MultipleAnswerQuestionOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultipleAnswerQuestionOptionRepository extends JpaRepository<MultipleAnswerQuestionOption, Long> {
}
