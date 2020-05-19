package com.uxtest.backend.model.questionnaire.question;

import com.uxtest.backend.dto.questionnaire.question.LikertScaleQuestionDTO;
import com.uxtest.backend.model.questionnaire.Questionnaire;
import com.uxtest.backend.dto.questionnaire.results.LikertScaleResultsDTO;
import com.uxtest.backend.dto.questionnaire.results.ResultsDTO;
import com.uxtest.backend.model.questionnaire.Questionnaire;
import com.uxtest.backend.model.questionnaire.answer.LikertScaleAnswer;
import com.uxtest.backend.model.questionnaire.answer.MultipleChoiceAnswer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LikertScaleQuestion implements Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String content;

    @OneToMany(mappedBy="question")
    private List<LikertScaleAnswer> answers;

    @NotNull
    private int possibleStepsNo;

    @ManyToOne
    @JoinColumn(nullable=false)
    private Questionnaire questionnaire;

    public LikertScaleQuestionDTO mapToDTO() {
        return LikertScaleQuestionDTO.builder()
                .id(getId())
                .content(getContent())
                .possibleStepsNo(getPossibleStepsNo())
                .build();
    }
    @Override
    public ResultsDTO getResults() {
        Stream<Integer> partialResult = this.getAnswers().stream()
                .map(LikertScaleAnswer::getAnswer);
        return LikertScaleResultsDTO.builder()
                .question(this.getContent())
                .answers(
                        partialResult
                        .collect(groupingBy(x -> x, counting()))
                )
                .build();
        }

}
