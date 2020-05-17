package com.uxtest.backend.dto.questionnaire.answer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LikertScaleAnswerDTO {

    @JsonProperty
    private Long id;

    @JsonProperty
    private int answer;

    @JsonProperty
    private Long questionId;

    @JsonProperty
    private Long userId;
}
