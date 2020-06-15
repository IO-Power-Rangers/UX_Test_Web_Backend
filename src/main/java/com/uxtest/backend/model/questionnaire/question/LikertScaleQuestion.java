package com.uxtest.backend.model.questionnaire.question;

import com.uxtest.backend.dto.questionnaire.question.LikertScaleQuestionDTO;
import com.uxtest.backend.dto.questionnaire.results.QuestionType;
import com.uxtest.backend.model.questionnaire.Questionnaire;
import com.uxtest.backend.dto.questionnaire.results.LikertScaleResultsDTO;
import com.uxtest.backend.dto.questionnaire.results.ResultsDTO;
import com.uxtest.backend.model.questionnaire.answer.LikertScaleAnswer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
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

    @Column(length=10485760, columnDefinition = "text")
    private String image;

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
                .image(getImage())
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

    @Override
    public List<? extends ExportDataAnswer> getDataAnswer() {
        return answers;
    }

    @Override
    public QuestionType getQuestionType() {
        return QuestionType.LIKERT_SCALE;
    }


}
