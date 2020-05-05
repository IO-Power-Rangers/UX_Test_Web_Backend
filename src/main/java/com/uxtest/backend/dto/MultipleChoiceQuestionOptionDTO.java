package com.uxtest.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.model.questionnaire.MultipleChoiceQuestionOption;
import com.uxtest.backend.model.questionnaire.TextQuestion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MultipleChoiceQuestionOptionDTO {

    @JsonProperty
    private String content;

    public MultipleChoiceQuestionOption parseMultipleChoiceQuestionOption() {
        return MultipleChoiceQuestionOption.builder()
                .content(getContent())
                .build();
    }
}
