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
    @JsonProperty
    private Long id;

    @JsonProperty
    @NotNull
    private String name;

    @JsonProperty
    @NotNull
    private Long testId;

    public TestGroup parseTestGroup(){
        return TestGroup.builder()
                .id(this.getId())
                .name(this.getName())
                .build();
    }
}
