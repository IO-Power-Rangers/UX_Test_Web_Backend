package com.uxtest.backend.repository;

import com.uxtest.backend.model.questionnaire.question.TextQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextQuestionRepository extends JpaRepository<TextQuestion, Long> {

}