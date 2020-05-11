package com.uxtest.backend.dto.questionnaire.question;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.model.questionnaire.question.LikertScaleQuestion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LikertScaleQuestionDTO {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String content;

    @JsonProperty
    private int possibleStepsNo;

    public LikertScaleQuestion parseLikertScaleQuestion() {
        return LikertScaleQuestion.builder()
                .content(getContent())
                .possibleStepsNo(getPossibleStepsNo())
                .build();
    }
}
