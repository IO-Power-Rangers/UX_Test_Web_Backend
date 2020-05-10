package com.uxtest.backend.model.questionnaire.question;

import com.uxtest.backend.dto.questionnaire.question.TextQuestionDTO;
import com.uxtest.backend.model.questionnaire.Questionnaire;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TextQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String content;

    @ManyToOne
    @JoinColumn(nullable=false)
    private Questionnaire questionnaire;

    public TextQuestionDTO mapToDTO() {
        return TextQuestionDTO.builder()
                .id(getId())
                .content(getContent())
                .build();
    }
}
