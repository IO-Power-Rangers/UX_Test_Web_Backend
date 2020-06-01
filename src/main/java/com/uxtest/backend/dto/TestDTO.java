package com.uxtest.backend.dto;

import com.uxtest.backend.dto.recording.RecordingDTO;
import com.uxtest.backend.model.questionnaire.Questionnaire;
import com.uxtest.backend.model.recording.Recording;
import com.uxtest.backend.model.test.Task;
import com.uxtest.backend.model.test.Test;
import com.uxtest.backend.model.user.User;
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

    private Questionnaire questionnaire;

    private User creator;

    @NotNull
    private String title;

    private List<Task> tasks;

    @NotNull
    private UxModel uxModel;

    private List<Long> recordingList;

    public Test parseTest() {
        return Test.builder()
                .id(this.getId())
                .title(this.getTitle())
                .tasks(this.getTasks())
                .uxModel(this.getUxModel())
                .questionnaire(this.getQuestionnaire())
                .creator(this.getCreator())
                .build();
    }
}
