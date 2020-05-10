package com.uxtest.backend.repository;

import com.uxtest.backend.model.Answer;
import com.uxtest.backend.model.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

}