package com.uxtest.backend.dto.questionnaire.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.dto.questionnaire.question.TextQuestionDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TextQuestionResultsDTO implements ResultsDTO {
    @JsonProperty
    @Builder.Default
    private QuestionType type = QuestionType.TEXT;

    @JsonProperty
    private String question;

    @JsonProperty
    private List<String> answers;
}
