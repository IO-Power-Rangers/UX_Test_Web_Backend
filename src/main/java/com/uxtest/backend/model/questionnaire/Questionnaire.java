package com.uxtest.backend.model.questionnaire;

import com.uxtest.backend.dto.questionnaire.QuestionnaireDTO;
import com.uxtest.backend.model.questionnaire.question.LikertScaleQuestion;
import com.uxtest.backend.model.questionnaire.question.MultipleAnswerQuestion;
import com.uxtest.backend.model.questionnaire.question.MultipleChoiceQuestion;
import com.uxtest.backend.model.questionnaire.question.TextQuestion;
import com.uxtest.backend.model.test.Test;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Questionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @NotNull
    private Test test;

    private String name;

    @OneToMany(mappedBy="questionnaire")
    private List<TextQuestion> textQuestions;

    @OneToMany(mappedBy="questionnaire")
    private List<MultipleChoiceQuestion> multipleChoiceQuestions;

    @OneToMany(mappedBy="questionnaire")
    private List<MultipleAnswerQuestion> multipleAnswerQuestions;

    @OneToMany(mappedBy="questionnaire")
    private List<LikertScaleQuestion> likertScaleQuestions;


    public QuestionnaireDTO mapToDTO() {
        return QuestionnaireDTO.builder()
                .id(getId())
                .name(getName())
                .textQuestions(getTextQuestions().stream()
                        .map(TextQuestion::mapToDTO)
                        .collect(Collectors.toList()))
                .multipleChoiceQuestions(getMultipleChoiceQuestions().stream()
                        .map(MultipleChoiceQuestion::mapToDTO)
                        .collect(Collectors.toList()))
                .multipleAnswerQuestions(getMultipleAnswerQuestions().stream()
                        .map(MultipleAnswerQuestion::mapToDTO)
                        .collect(Collectors.toList()))
                .likertScaleQuestions(getLikertScaleQuestions().stream()
                        .map(LikertScaleQuestion::mapToDTO)
                        .collect(Collectors.toList()))
                .build();
    }
}
