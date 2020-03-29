package com.uxtest.backend.model.survey;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Survey {
    private final String name;

    public Survey(@JsonProperty("name") String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
