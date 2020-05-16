package com.uxtest.backend.dto.questionnaire.answer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.dto.UserDTO;
import com.uxtest.backend.dto.questionnaire.question.TextQuestionDTO;
import com.uxtest.backend.model.questionnaire.answer.TextAnswer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TextAnswerDTO {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String answer;

    @JsonProperty
    private Long questionId;

    @JsonProperty
    private Long userId;
}
