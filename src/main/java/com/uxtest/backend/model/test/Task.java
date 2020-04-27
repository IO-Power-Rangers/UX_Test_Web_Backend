package com.uxtest.backend.model.test;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.uxtest.backend.dto.TaskDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Task")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @NotNull
    private String description;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;


    public TaskDTO mapToDTO() {
        return TaskDTO.builder()
                .id(this.getId())
                .name(this.getName())
                .description(this.getDescription())
                .test(this.getTest())
                .build();
    }
}
