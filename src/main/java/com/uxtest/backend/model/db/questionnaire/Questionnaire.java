package com.uxtest.backend.model.db.questionnaire;

import javax.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
public class Questionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="QuestionnaireId")
    private UUID id;

    @Column(name="Name")
    private String name;

    @OneToMany(mappedBy = "questionnaire")
    private Set<Question> questions;

    public Questionnaire() { }

    public Questionnaire(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public Set<Question> getQuestions() {
        return questions;
    }
}
