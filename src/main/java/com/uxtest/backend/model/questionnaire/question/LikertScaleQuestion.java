package com.uxtest.backend.model.questionnaire.question;

import com.uxtest.backend.dto.question.LikertScaleQuestionDTO;
import com.uxtest.backend.model.questionnaire.Questionnaire;
import com.uxtest.backend.model.questionnaire.answer.LikertScaleAnswer;
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
public class LikertScaleQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String content;

    @NotNull
    private int range; // number of possible steps in Likert scale

    @ManyToOne
    @JoinColumn(nullable=false)
    private Questionnaire questionnaire;


    public LikertScaleQuestionDTO mapToDTO() {
        return LikertScaleQuestionDTO.builder()
                .id(getId())
                .content(getContent())
                .range(getRange())
                .build();
    }
}
