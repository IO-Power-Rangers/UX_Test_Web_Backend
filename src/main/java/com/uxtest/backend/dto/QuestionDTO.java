package com.uxtest.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionDTO {

    @JsonProperty
    private String content;

    public String getContent() {
        return content;
    }
}
