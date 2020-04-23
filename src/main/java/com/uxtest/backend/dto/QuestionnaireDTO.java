package com.uxtest.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.model.Question;
import com.uxtest.backend.model.Questionnaire;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    public String getName() {
        return name;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public Questionnaire toQuestionnaire() {

       return Questionnaire.builder()
               .name(this.name)
               .questions(this.questions.stream()
                       .map(QuestionDTO::toQuestion)
                       .collect(Collectors.toList()))
               .build();


    }
}
