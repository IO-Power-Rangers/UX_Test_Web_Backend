package com.uxtest.backend.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.model.grouping.TestGroup;
import com.uxtest.backend.model.test.Test;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestGroupDTO {
    private Long id;

    @NotNull
    private String name;

    @JsonProperty
    private Test test;

    public TestGroup parseTestGroup(){
        return TestGroup.builder()
                .id(this.getId())
                .name(this.getName())
                .build();
    }
}
