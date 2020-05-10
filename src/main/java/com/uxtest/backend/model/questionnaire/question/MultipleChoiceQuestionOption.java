package com.uxtest.backend.model.questionnaire.question;

import com.uxtest.backend.dto.MultipleChoiceQuestionOptionDTO;
import com.uxtest.backend.model.questionnaire.answer.MultipleChoiceAnswer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MultipleChoiceQuestionOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String content;

    @ManyToOne
    @JoinColumn(nullable=false)
    private MultipleChoiceQuestion multipleChoiceQuestion;

    @OneToMany(mappedBy="selectedOption")
    private List<MultipleChoiceAnswer> answers;

    public MultipleChoiceQuestionOptionDTO mapToDTO() {
        return MultipleChoiceQuestionOptionDTO.builder()
                .content(getContent())
                .build();
    }
}
