package com.uxtest.backend.model;

import com.uxtest.backend.dto.QuestionnaireDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;
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

    public List<Question> getQuestions() {
        return questions;
    }

    public QuestionnaireDTO mapToDTO() {
        return QuestionnaireDTO.builder()
                .name(getName())
                .questions(getQuestions().stream()
                        .map(Question::mapToDTO)
                        .collect(Collectors.toList()))
                .build();
    }
}
