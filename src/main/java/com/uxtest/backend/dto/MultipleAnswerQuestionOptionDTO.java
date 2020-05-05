package com.uxtest.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.model.questionnaire.question.MultipleAnswerQuestionOption;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MultipleAnswerQuestionOptionDTO {

    @JsonProperty
    private String content;

    public MultipleAnswerQuestionOption parseMultipleAnswerQuestionOption() {
        return MultipleAnswerQuestionOption.builder()
                .content(getContent())
                .build();
    }
}
