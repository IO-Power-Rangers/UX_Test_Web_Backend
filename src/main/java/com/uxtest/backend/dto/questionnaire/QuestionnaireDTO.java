package com.uxtest.backend.dto.questionnaire;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.dto.questionnaire.question.LikertScaleQuestionDTO;
import com.uxtest.backend.dto.questionnaire.question.MultipleAnswerQuestionDTO;
import com.uxtest.backend.dto.questionnaire.question.MultipleChoiceQuestionDTO;
import com.uxtest.backend.dto.questionnaire.question.TextQuestionDTO;
import com.uxtest.backend.model.questionnaire.Questionnaire;
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
public class QuestionnaireDTO {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String name;

    @JsonProperty
    private List<TextQuestionDTO> textQuestions;

    @JsonProperty
    private List<MultipleChoiceQuestionDTO> multipleChoiceQuestions;

    @JsonProperty
    private List<MultipleAnswerQuestionDTO> multipleAnswerQuestions;

    @JsonProperty
    private List<LikertScaleQuestionDTO> likertScaleQuestions;

    public Questionnaire parseQuestionnaire() {

       return Questionnaire.builder()
               .name(getName())
               .textQuestions(getTextQuestions().stream()
                    .map(TextQuestionDTO::parseTextQuestion)
                    .collect(Collectors.toList()))
               .multipleChoiceQuestions(getMultipleChoiceQuestions().stream()
                       .map(MultipleChoiceQuestionDTO::parseMultipleChoiceQuestion)
                       .collect(Collectors.toList()))
               .multipleAnswerQuestions(getMultipleAnswerQuestions().stream()
                       .map(MultipleAnswerQuestionDTO::parseMultipleChoiceQuestion)
                       .collect(Collectors.toList()))
               .likertScaleQuestions(getLikertScaleQuestions().stream()
                       .map(LikertScaleQuestionDTO::parseLikertScaleQuestion)
                       .collect(Collectors.toList()))
               .build();
    }
}
