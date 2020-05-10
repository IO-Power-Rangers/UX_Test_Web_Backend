package com.uxtest.backend.dto.answer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.model.questionnaire.answer.LikertScaleAnswer;
import com.uxtest.backend.model.questionnaire.question.LikertScaleQuestion;
import com.uxtest.backend.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LikertScaleAnswerDTO {

    @JsonProperty
    private Long id;

    @JsonProperty
    private int answer;

    @JsonProperty
    private LikertScaleQuestion question;

    @JsonProperty
    private User user;

    public LikertScaleAnswer parseLikertScaleAnswer() {
        return LikertScaleAnswer.builder()
                .id(getId())
                .answer(getAnswer())
                .question(getQuestion())
                .user(getUser())
                .build();
    }
}
