package com.uxtest.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.model.Questionnaire;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionnaireDTO {

    @JsonProperty
    private String name;
    @JsonProperty
    private List<QuestionDTO> questions;

    public Questionnaire parseQuestionnaire() {

       return Questionnaire.builder()
               .name(getName())
               .questions(getQuestions().stream()
                       .map(QuestionDTO::parseQuestion)
                       .collect(Collectors.toList()))
               .build();


    }
}
