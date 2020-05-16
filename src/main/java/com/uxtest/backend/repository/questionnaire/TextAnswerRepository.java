package com.uxtest.backend.repository.questionnaire;

import com.uxtest.backend.model.questionnaire.answer.TextAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextAnswerRepository extends JpaRepository<TextAnswer, Long> {

}
