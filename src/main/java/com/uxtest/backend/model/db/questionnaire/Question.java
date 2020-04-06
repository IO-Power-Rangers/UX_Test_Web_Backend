package com.uxtest.backend.model.db.questionnaire;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="QuestionId")
    private UUID id;

    @Column(name="Content")
    private String content;

    @ManyToOne
    @JoinColumn(name="QuestionnaireId", nullable=false)
    private Questionnaire questionnaire;

    @OneToMany(mappedBy = "question")
    private Set<Answer> answers;

    public Question() { }

    public Question(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public UUID getId() {
        return id;
    }
}
