package com.uxtest.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.dto.questionnaire.QuestionnaireDTO;
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
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestDTO {
    private Long id;

    @JsonProperty
    private QuestionnaireDTO questionnaire;

    @JsonProperty
    private UserDTO creator;

    @NotNull
    private String title;

    @JsonProperty
    private List<TaskDTO> tasks;

    @JsonProperty
    @NotNull
    private UxModelDTO uxModel;

    private List<Long> recordingList;

    public Test parseTest() {
        return Test.builder()
                .id(this.getId())
                .title(this.getTitle())
                .tasks(this.getTasks().stream().map(TaskDTO::parseTask).collect(Collectors.toList()))
                .uxModel(this.getUxModel().parseUxModel())
               // .questionnaire(this.getQuestionnaire().parseQuestionnaire())
                .creator(this.getCreator().parseUser())
                .build();
    }
}
