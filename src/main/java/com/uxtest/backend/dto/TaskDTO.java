package com.uxtest.backend.dto;

import com.uxtest.backend.model.test.Task;
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
public class TaskDTO {
    private Long id;

    private String name;

    @NotNull
    private int index;

    @NotNull
    private String description;

    public Task parseTask() {
        return Task.builder()
                .name(this.getName())
                .description(this.getDescription())
                .index(this.getIndex())
                .build();
    }
}
