package com.uxtest.backend.dto.questionnaire.answer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.dto.UserDTO;
import com.uxtest.backend.dto.questionnaire.question.MultipleChoiceQuestionDTO;
import com.uxtest.backend.dto.questionnaire.question.MultipleChoiceQuestionOptionDTO;
import com.uxtest.backend.model.questionnaire.Questionnaire;
import com.uxtest.backend.model.questionnaire.answer.MultipleChoiceAnswer;
import com.uxtest.backend.model.questionnaire.question.MultipleChoiceQuestion;
import com.uxtest.backend.model.questionnaire.question.MultipleChoiceQuestionOption;
import com.uxtest.backend.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MultipleChoiceAnswerDTO {

    @JsonProperty
    private Long id;

    @JsonProperty
    private Long selectedOptionId;

    @JsonProperty
    private Long questionId;

    @JsonProperty
    private Long userId;

}
