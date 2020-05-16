package com.uxtest.backend.model.questionnaire.answer;

import com.uxtest.backend.dto.questionnaire.answer.LikertScaleAnswerDTO;
import com.uxtest.backend.model.questionnaire.question.LikertScaleQuestion;
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
public class LikertScaleAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int answer;

    @ManyToOne
    @JoinColumn(nullable=false)
    private LikertScaleQuestion question;

    @ManyToOne
    @JoinColumn(nullable=false)
    private User user;
}