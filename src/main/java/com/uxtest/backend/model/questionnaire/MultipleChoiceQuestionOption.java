package com.uxtest.backend.model.questionnaire;

import com.uxtest.backend.dto.MultipleChoiceQuestionOptionDTO;
import com.uxtest.backend.dto.TextQuestionDTO;
import com.uxtest.backend.model.Answer;
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
    private MultipleChoiceQuestion question;

    public MultipleChoiceQuestionOptionDTO mapToDTO() {
        return MultipleChoiceQuestionOptionDTO.builder()
                .content(getContent())
                .build();
    }
}
