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
public class MultipleAnswerResultsDTO implements ResultsDTO {
    @JsonProperty
    @Builder.Default
    private QuestionType type = QuestionType.MULTIPLE_ANSWER;

    @JsonProperty
    private String question;

    @JsonProperty
    private Map<String, Long> answers;
}
