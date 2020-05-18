package com.uxtest.backend.model.test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.uxtest.backend.dto.TaskDTO;
import com.uxtest.backend.dto.TestDTO;
import com.uxtest.backend.model.recording.Recording;
import com.uxtest.backend.model.uxmodel.UxModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "Test")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @OneToMany(mappedBy = "test")
    @JsonIgnoreProperties("test")
    private List<Task> tasks;

    @ManyToOne
    @JoinColumn(name = "uxModel_axLink")
    @JsonIgnoreProperties("tests")
    @NotNull
    private UxModel uxModel;

    @OneToMany(mappedBy = "test")
    @JsonIgnoreProperties("test")
    private List<Recording> recordings;

    public TestDTO mapToDTO() {
        return TestDTO.builder()
                .id(this.getId())
                .title(this.getTitle())
                .tasks(this.getTasks())
                .uxModel(this.getUxModel())
                .recordingList(this.recordings.stream().map(Recording::getId).collect(Collectors.toList()))
                .build();
    }
}