package com.uxtest.backend.dto.question;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.model.questionnaire.question.MultipleChoiceQuestion;
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
public class MultipleChoiceQuestionDTO {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String content;

    @JsonProperty
    private List<MultipleChoiceQuestionOptionDTO> options;

    public MultipleChoiceQuestion parseMultipleChoiceQuestion() {

        return MultipleChoiceQuestion.builder()
                .content(getContent())
                .options(getOptions().stream()
                    .map(MultipleChoiceQuestionOptionDTO::parseMultipleChoiceQuestionOption)
                    .collect(Collectors.toList()))
                .build();


    }
}