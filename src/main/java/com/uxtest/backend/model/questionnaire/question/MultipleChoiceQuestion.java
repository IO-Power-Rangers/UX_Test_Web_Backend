package com.uxtest.backend.model.questionnaire.question;

import com.uxtest.backend.dto.MultipleChoiceQuestionDTO;
import com.uxtest.backend.model.questionnaire.Questionnaire;
import com.uxtest.backend.model.questionnaire.answer.MultipleChoiceAnswer;
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
public class MultipleChoiceQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String content;

    @OneToMany(mappedBy="multipleChoiceQuestion")
    private List<MultipleChoiceQuestionOption> options;

    @OneToMany(mappedBy="question")
    private List<MultipleChoiceAnswer> answers;

    @ManyToOne
    @JoinColumn(nullable=false)
    private Questionnaire questionnaire;

    public MultipleChoiceQuestionDTO mapToDTO() {
        return MultipleChoiceQuestionDTO.builder()
                .content(getContent())
                .options(getOptions().stream()
                    .map(MultipleChoiceQuestionOption::mapToDTO)
                    .collect(Collectors.toList()))
                .build();
    }
}
