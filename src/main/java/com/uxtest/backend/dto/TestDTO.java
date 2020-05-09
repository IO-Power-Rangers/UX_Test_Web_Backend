package com.uxtest.backend.dto;

import com.uxtest.backend.model.test.Task;
import com.uxtest.backend.model.test.Test;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestDTO {
    private Long id;

    @NotNull
    private String title;

    private List<Task> tasks;

    public Test parseTest() {
        return Test.builder()
                .id(this.getId())
                .title(this.getTitle())
                .tasks(this.tasks)
                .build();
    }
}
