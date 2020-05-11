package com.uxtest.backend.model.questionnaire.question;

import com.uxtest.backend.dto.questionnaire.question.TextQuestionDTO;
import com.uxtest.backend.dto.questionnaire.results.ResultsDTO;
import com.uxtest.backend.dto.questionnaire.results.TextQuestionResultsDTO;
import com.uxtest.backend.model.questionnaire.Questionnaire;
import com.uxtest.backend.model.questionnaire.answer.TextAnswer;
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
public class TextQuestion implements Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String content;

    @ManyToOne
    @JoinColumn(nullable=false)
    private Questionnaire questionnaire;

    @OneToMany(mappedBy="question")
    private List<TextAnswer> answers;

    public TextQuestionDTO mapToDTO() {
        return TextQuestionDTO.builder()
                .id(getId())
                .content(getContent())
                .build();
    }

    @Override
    public ResultsDTO getResults() {
        return TextQuestionResultsDTO.builder()
                .question(this.getContent())
                .answers(this.getAnswers().stream().map(TextAnswer::getAnswer).collect(Collectors.toList()))
                .build();
    }
}
