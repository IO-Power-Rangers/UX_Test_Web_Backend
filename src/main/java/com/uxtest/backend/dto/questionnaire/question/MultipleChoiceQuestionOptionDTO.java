package com.uxtest.backend.dto.question;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.model.questionnaire.question.MultipleChoiceQuestionOption;
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
    private Long id;

    @JsonProperty
    private String content;

    public MultipleChoiceQuestionOption parseMultipleChoiceQuestionOption() {
        return MultipleChoiceQuestionOption.builder()
                .content(getContent())
                .build();
    }
}
