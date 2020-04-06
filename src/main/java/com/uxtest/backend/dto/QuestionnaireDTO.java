package com.uxtest.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.model.Questionnaire;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class QuestionnaireDTO {

    @JsonProperty
    private String name;
    @JsonProperty
    private List<QuestionDTO> questions;

    public String getName() {
        return name;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public Questionnaire toQuestionnaire() {
        // TODO
    }


}
