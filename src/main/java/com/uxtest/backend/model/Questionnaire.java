package com.uxtest.backend.model;

import com.uxtest.backend.dto.QuestionDTO;
import com.uxtest.backend.dto.QuestionnaireDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Questionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "questionnaire")
    private List<Question> questions;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public QuestionnaireDTO toDTO() {
        return QuestionnaireDTO.builder()
                .name(this.name)
                .questions(this.questions.stream()
                        .map(Question::toDTO)
                        .collect(Collectors.toList()))
                .build();
    }
}
