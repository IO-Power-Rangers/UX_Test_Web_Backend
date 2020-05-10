package com.uxtest.backend.dto.answer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.model.questionnaire.answer.MultipleAnswerAnswer;
import com.uxtest.backend.model.questionnaire.question.MultipleAnswerQuestion;
import com.uxtest.backend.model.questionnaire.question.MultipleAnswerQuestionOption;
import com.uxtest.backend.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MultipleAnswerAnswerDTO {

    @JsonProperty
    private Long id;

    @JsonProperty
    private List<MultipleAnswerQuestionOption> selectedOptions;

    @JsonProperty
    private MultipleAnswerQuestion question;

    @JsonProperty
    private User user;

//    public MultipleAnswerAnswer parseMultipleAnswerAnswer() {
//        return MultipleAnswerAnswer.builder()
//                .id(getId())
//                .selectedOptions()
//                .
//    }
}
