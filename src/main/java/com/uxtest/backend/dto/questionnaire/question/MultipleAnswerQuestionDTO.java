package com.uxtest.backend.dto.questionnaire.question;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.model.questionnaire.question.MultipleAnswerQuestion;
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
public class MultipleAnswerQuestionDTO {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String content;

    @JsonProperty
    private List<MultipleAnswerQuestionOptionDTO> options;

    public MultipleAnswerQuestion parseMultipleChoiceQuestion() {

        return MultipleAnswerQuestion.builder()
                .content(getContent())
                .options(getOptions().stream()
                        .map(MultipleAnswerQuestionOptionDTO::parseMultipleAnswerQuestionOption)
                        .collect(Collectors.toList()))
                .build();


    }
}
