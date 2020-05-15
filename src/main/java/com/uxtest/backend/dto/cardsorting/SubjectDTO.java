package com.uxtest.backend.dto.cardsorting;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.model.cardsorting.CardSortingTest;
import com.uxtest.backend.model.cardsorting.CategoryWithSubjects;
import com.uxtest.backend.model.cardsorting.Subject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {
    private Long id;

    @JsonProperty
    private String name;

    public Subject parseSubject() {
        return Subject.builder()
                .id(this.getId())
                .name(this.getName())
                .build();
    }
}
