package com.uxtest.backend.model.questionnaire.answer;

import com.uxtest.backend.model.questionnaire.question.*;
import com.uxtest.backend.model.user.User;
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
public class MultipleAnswerAnswer extends ExportDataAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<MultipleAnswerQuestionOption> selectedOptions;

    @ManyToOne
    @JoinColumn(nullable = false)
    private MultipleAnswerQuestion question;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    @Override
    public AnswerExport getAnswerExport() {
        StringBuilder builder = new StringBuilder();
        for (MultipleAnswerQuestionOption option : selectedOptions) {
            builder.append(option.getContent());
            builder.append(" ");
        }
        String answers = builder.toString();
        return new AnswerExport(answers, user);
    }
}