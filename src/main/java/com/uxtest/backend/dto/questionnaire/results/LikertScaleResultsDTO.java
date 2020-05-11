package com.uxtest.backend.dto.questionnaire.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LikertScaleResultsDTO implements ResultsDTO {
    @JsonProperty
    @Builder.Default
    private QuestionType type = QuestionType.LIKERT_SCALE;

    @JsonProperty
    private String question;

    @JsonProperty
    private Map<Integer, Long> answers;

}
