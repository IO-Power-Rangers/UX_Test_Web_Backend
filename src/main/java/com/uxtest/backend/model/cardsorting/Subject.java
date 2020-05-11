package com.uxtest.backend.model.cardsorting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uxtest.backend.dto.cardsorting.SubjectDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "cardSortingTest_id")
    @JsonIgnoreProperties("subjects")
    private CardSortingTest test;

    @ManyToOne
    @JoinColumn(name = "categoryWithSubjects_id")
    @JsonIgnoreProperties("subjects")
    private CategoryWithSubjects categoryWithSubjects;

    public SubjectDTO mapToDTO() {
        return SubjectDTO.builder()
                .id(this.getId())
                .name(this.getName())
                .test(this.getTest())
                .categoryWithSubjects(this.getCategoryWithSubjects())
                .build();
    }
}
