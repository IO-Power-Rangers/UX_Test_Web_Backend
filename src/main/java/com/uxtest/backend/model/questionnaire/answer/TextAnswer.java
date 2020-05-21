package com.uxtest.backend.model.questionnaire.answer;

import com.uxtest.backend.model.questionnaire.question.AnswerExport;
import com.uxtest.backend.model.questionnaire.question.ExportDataAnswer;
import com.uxtest.backend.model.questionnaire.question.TextQuestion;
import com.uxtest.backend.model.user.User;
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
public class TextAnswer extends ExportDataAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String answer;

    @ManyToOne
    @JoinColumn(nullable=false)
    private TextQuestion question;

    @ManyToOne
    @JoinColumn(nullable=false)
    private User user;

    @Override
    public AnswerExport getAnswerExport() {
        return new AnswerExport(answer,user);
    }
}
