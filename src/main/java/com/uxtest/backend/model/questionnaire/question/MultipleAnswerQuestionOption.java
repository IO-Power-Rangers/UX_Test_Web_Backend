package com.uxtest.backend.model.questionnaire.question;

import com.uxtest.backend.dto.MultipleAnswerQuestionOptionDTO;
import com.uxtest.backend.model.questionnaire.answer.MultipleAnswerAnswer;
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
public class MultipleAnswerQuestionOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String content;

    @ManyToOne
    @JoinColumn(nullable=false)
    private MultipleAnswerQuestion multipleAnswerQuestion;

    @ManyToMany(mappedBy="selectedOptions")
    private List<MultipleAnswerAnswer> answers;

    public MultipleAnswerQuestionOptionDTO mapToDTO() {
        return MultipleAnswerQuestionOptionDTO.builder()
                .content(getContent())
                .build();
    }
}

