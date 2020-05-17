package com.uxtest.backend.dto.questionnaire.answer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.model.questionnaire.question.MultipleAnswerQuestion;
import com.uxtest.backend.model.questionnaire.question.MultipleAnswerQuestionOption;
import com.uxtest.backend.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MultipleAnswerAnswerDTO {

    @JsonProperty
    private Long id;

    @JsonProperty
    private List<Long> selectedOptionsIds;

    @JsonProperty
    private Long questionId;

    @JsonProperty
    private Long userId;
}
