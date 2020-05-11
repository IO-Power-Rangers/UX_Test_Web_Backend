package com.uxtest.backend.model.questionnaire.question;

import com.uxtest.backend.dto.questionnaire.question.MultipleAnswerQuestionDTO;
import com.uxtest.backend.model.questionnaire.Questionnaire;

import com.uxtest.backend.dto.questionnaire.results.MultipleAnswerResultsDTO;
import com.uxtest.backend.dto.questionnaire.results.ResultsDTO;
import com.uxtest.backend.model.questionnaire.Questionnaire;
import com.uxtest.backend.model.questionnaire.answer.MultipleAnswerAnswer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MultipleAnswerQuestion implements Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String content;

    @OneToMany(mappedBy="multipleAnswerQuestion")
    private List<MultipleAnswerQuestionOption> options;

    @OneToMany(mappedBy="question")
    private List<MultipleAnswerAnswer> answers;


    @ManyToOne
    @JoinColumn(nullable=false)
    private Questionnaire questionnaire;

    public MultipleAnswerQuestionDTO mapToDTO() {
        return MultipleAnswerQuestionDTO.builder()
                .id(getId())
                .content(getContent())
                .options(getOptions().stream()
                        .map(MultipleAnswerQuestionOption::mapToDTO)
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public ResultsDTO getResults() {
        return MultipleAnswerResultsDTO.builder()
                .question(this.getContent())
                .answers(
                        this.getAnswers().stream()
                            .flatMap(p -> p.getSelectedOptions().stream())
                            .collect(groupingBy(MultipleAnswerQuestionOption::getContent, counting()))
                )
                .build();
    }
}