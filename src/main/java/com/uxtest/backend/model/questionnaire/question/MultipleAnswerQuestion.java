package com.uxtest.backend.model.questionnaire.question;

import com.uxtest.backend.dto.question.MultipleAnswerQuestionDTO;
import com.uxtest.backend.model.questionnaire.Questionnaire;
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
public class MultipleAnswerQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String content;

    @OneToMany(mappedBy="multipleAnswerQuestion")
    private List<MultipleAnswerQuestionOption> options;


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
}