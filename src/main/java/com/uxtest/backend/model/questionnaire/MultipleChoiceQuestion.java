package com.uxtest.backend.model.questionnaire;

import com.uxtest.backend.dto.MultipleChoiceQuestionDTO;
import com.uxtest.backend.dto.TextQuestionDTO;
import com.uxtest.backend.model.Answer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @OneToMany(mappedBy="question")
    private List<MultipleChoiceQuestionOption> options;

    @ManyToOne
    @JoinColumn(name="questionnaireId", nullable=false)
    private Questionnaire questionnaire;

    public MultipleChoiceQuestionDTO mapToDTO() {
        return MultipleChoiceQuestionDTO.builder()
                .options(getOptions().stream()
                    .map(MultipleChoiceQuestionOption::mapToDTO)
                    .collect(Collectors.toList()))
                .build();
    }
}
