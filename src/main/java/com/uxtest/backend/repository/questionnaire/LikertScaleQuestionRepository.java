package com.uxtest.backend.repository.questionnaire;

import com.uxtest.backend.model.questionnaire.question.LikertScaleQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikertScaleQuestionRepository extends JpaRepository<LikertScaleQuestion, Long> {
}
