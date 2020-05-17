package com.uxtest.backend.repository.questionnaire;

import com.uxtest.backend.model.questionnaire.answer.MultipleAnswerAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultipleAnswerAnswerRepository extends JpaRepository<MultipleAnswerAnswer, Long> {
}
