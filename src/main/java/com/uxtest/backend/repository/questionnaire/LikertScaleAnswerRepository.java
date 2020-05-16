package com.uxtest.backend.repository.questionnaire;

import com.uxtest.backend.model.questionnaire.answer.LikertScaleAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikertScaleAnswerRepository extends JpaRepository<LikertScaleAnswer, Long> {
}
