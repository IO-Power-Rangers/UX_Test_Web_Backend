package com.uxtest.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.model.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {

    @JsonProperty
    private String content;

    public Question parseQuestion() {
        return Question.builder()
                .content(getContent())
                .build();
    }
}
