package com.uxtest.backend.model;

import javax.persistence.*;
import java.util.UUID;

public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="AnswerId")
    private UUID id;

    @ManyToOne
    @JoinColumn(name="QuestionId", nullable=false)
    private Question question;
}
