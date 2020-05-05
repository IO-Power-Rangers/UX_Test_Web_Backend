package com.uxtest.backend.repository;

import com.uxtest.backend.model.questionnaire.MultipleChoiceQuestionOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultipleChoiceQuestionOptionRepository extends JpaRepository<MultipleChoiceQuestionOption, Long> {

}
