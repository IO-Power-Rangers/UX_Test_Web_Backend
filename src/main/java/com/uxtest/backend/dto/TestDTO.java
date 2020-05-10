package com.uxtest.backend.dto;

import com.uxtest.backend.model.test.Task;
import com.uxtest.backend.model.test.Test;
import com.uxtest.backend.model.uxmodel.UxModel;
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

    @NotNull
    private UxModel uxModel;

    public Test parseTest() {
        return Test.builder()
                .title(this.getTitle())
                .tasks(this.getTasks())
                .uxModel(this.getUxModel())
                .build();
    }
}
