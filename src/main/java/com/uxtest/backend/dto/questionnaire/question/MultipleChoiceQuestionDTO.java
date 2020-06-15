package com.uxtest.backend.dto.questionnaire.question;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.model.questionnaire.question.MultipleChoiceQuestion;
import com.uxtest.backend.model.questionnaire.question.MultipleChoiceQuestionOption;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MultipleChoiceQuestionDTO {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String content;

    @JsonProperty
    private String image;

    @JsonProperty
    private List<MultipleChoiceQuestionOptionDTO> options;

    public MultipleChoiceQuestion parseMultipleChoiceQuestion() {

        List<MultipleChoiceQuestionOption> options = null;

        if (getOptions() != null) {
            options = getOptions().stream()
                    .map(MultipleChoiceQuestionOptionDTO::parseMultipleChoiceQuestionOption)
                    .collect(Collectors.toList());
        }

        return MultipleChoiceQuestion.builder()
                .id(getId())
                .content(getContent())
                .image(getImage())
                .options(options)
                .build();


    }
}