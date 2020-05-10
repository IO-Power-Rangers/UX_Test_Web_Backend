package com.uxtest.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.model.questionnaire.Questionnaire;
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
    private List<TextQuestionDTO> textQuestions;

    @JsonProperty
    private List<MultipleChoiceQuestionDTO> multipleChoiceQuestions;

    public Questionnaire parseQuestionnaire() {

       return Questionnaire.builder()
               .name(getName())
               .textQuestions(getTextQuestions().stream()
                       .map(TextQuestionDTO::parseTextQuestion)
                       .collect(Collectors.toList()))
               .multipleChoiceQuestions(getMultipleChoiceQuestions().stream()
                        .map(MultipleChoiceQuestionDTO::parseMultipleChoiceQuestion)
                        .collect(Collectors.toList()))
               .build();


    }
}
