package com.uxtest.backend.model.questionnaire.question;

import com.uxtest.backend.dto.TextQuestionDTO;
import com.uxtest.backend.model.questionnaire.Questionnaire;
import com.uxtest.backend.model.questionnaire.answer.TextAnswer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TextQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(nullable=false)
    private Questionnaire questionnaire;

    @OneToMany(mappedBy="question")
    private List<TextAnswer> answers;

    public TextQuestionDTO mapToDTO() {
        return TextQuestionDTO.builder()
                .content(getContent())
                .build();
    }
}
