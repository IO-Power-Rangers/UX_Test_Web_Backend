package com.uxtest.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.model.questionnaire.MultipleChoiceQuestion;
import com.uxtest.backend.model.questionnaire.MultipleChoiceQuestionOption;
import com.uxtest.backend.model.questionnaire.Questionnaire;
import com.uxtest.backend.model.questionnaire.TextQuestion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MultipleChoiceQuestionDTO {

    @JsonProperty
    private List<MultipleChoiceQuestionOptionDTO> options;

    public MultipleChoiceQuestion parseMultipleChoiceQuestion() {

        return MultipleChoiceQuestion.builder()
                .options(getOptions().stream()
                    .map(MultipleChoiceQuestionOptionDTO::parseMultipleChoiceQuestionOption)
                    .collect(Collectors.toList()))
                .build();


    }
}