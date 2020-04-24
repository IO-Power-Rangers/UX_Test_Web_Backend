package com.uxtest.backend.model;

import com.uxtest.backend.dto.QuestionDTO;
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
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name="questionnaireId", nullable=false)
    private Questionnaire questionnaire;

    @OneToMany(mappedBy="question")
    private List<Answer> answers;


    public Question(String content) {
        this.content = content;
    }

    public QuestionDTO mapToDTO() {
        return QuestionDTO.builder()
                .content(getContent())
                .build();
    }
}
