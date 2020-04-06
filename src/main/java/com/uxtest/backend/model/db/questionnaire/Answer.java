package com.uxtest.backend.model.db.questionnaire;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Answer {

    private String content;

    @ManyToOne
    @JoinColumn(name="QuestionId", nullable=false)
    private Question question;

    public Answer() { }
}
