package com.uxtest.backend.repository;

import com.uxtest.backend.model.questionnaire.TextQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<TextQuestion, Long> {

}