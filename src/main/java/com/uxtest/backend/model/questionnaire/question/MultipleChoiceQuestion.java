package com.uxtest.backend.model.questionnaire.question;

import com.uxtest.backend.dto.questionnaire.question.MultipleChoiceQuestionDTO;
import com.uxtest.backend.dto.questionnaire.results.MultipleChoiceResultsDTO;
import com.uxtest.backend.dto.questionnaire.results.QuestionType;
import com.uxtest.backend.dto.questionnaire.results.ResultsDTO;
import com.uxtest.backend.model.questionnaire.Questionnaire;
import com.uxtest.backend.model.questionnaire.answer.MultipleChoiceAnswer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MultipleChoiceQuestion implements Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String content;

    @OneToMany(mappedBy="question")
    private List<MultipleChoiceAnswer> answers;

    @OneToMany(mappedBy="multipleChoiceQuestion")
    private List<MultipleChoiceQuestionOption> options;

    @ManyToOne
    @JoinColumn(nullable=false)
    private Questionnaire questionnaire;

    public MultipleChoiceQuestionDTO mapToDTO() {
        return MultipleChoiceQuestionDTO.builder()
                .id(getId())
                .content(getContent())
                .options(getOptions().stream()
                    .map(MultipleChoiceQuestionOption::mapToDTO)
                    .collect(Collectors.toList()))
                .build();
    }

    @Override
    public ResultsDTO getResults() {
        return MultipleChoiceResultsDTO.builder()
                .question(this.getContent())
                .answers(this.getAnswers().stream()
                        .map(MultipleChoiceAnswer::getSelectedOption)
                        .collect(groupingBy(MultipleChoiceQuestionOption::getContent, counting()))
                )
                .build();
    }

    @Override
    public List<? extends ExportDataAnswer> getDataAnswer() {
        return answers;
    }

    @Override
    public QuestionType getQuestionType() {
        return QuestionType.MULTIPLE_CHOICE;
    }

}
