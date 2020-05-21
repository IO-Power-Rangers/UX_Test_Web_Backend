package com.uxtest.backend.dto.questionnaire.results;

import com.fasterxml.jackson.annotation.JsonValue;

public enum QuestionType {
    LIKERT_SCALE, MULTIPLE_CHOICE, MULTIPLE_ANSWER, TEXT;

    @JsonValue
    public String value() {
        return this.toString();
    }

    public String getLowerCase(){
        return this.toString().toLowerCase().replace('_', ' ');
    }

}
