package com.uxtest.backend.model.questionnaire.answer;

import com.uxtest.backend.model.questionnaire.question.MultipleChoiceQuestion;
import com.uxtest.backend.model.questionnaire.question.MultipleChoiceQuestionOption;
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
public class MultipleChoiceAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable=false)
    private MultipleChoiceQuestionOption selectedOption;

    @ManyToOne
    @JoinColumn(nullable=false)
    private MultipleChoiceQuestion question;

    @ManyToOne
    @JoinColumn(nullable=false)
    private User user;
}
