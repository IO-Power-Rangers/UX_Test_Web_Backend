package com.uxtest.backend.dto.cardsorting;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.model.cardsorting.CardSortingResult;
import com.uxtest.backend.model.cardsorting.CardSortingTest;
import com.uxtest.backend.model.cardsorting.Category;
import com.uxtest.backend.model.cardsorting.Subject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardSortingTestDTO {
    private Long id;
    @JsonProperty
    private List<CategoryDTO> categories;
    @JsonProperty
    private List<SubjectDTO> subjects;

    public CardSortingTest parseTest() {
        return CardSortingTest.builder()
                .id(this.getId())
                .categories(this.getCategories()
                    .stream()
                    .map(CategoryDTO::parseCategory)
                    .collect(Collectors.toList()))
                .subjects(this.getSubjects()
                    .stream()
                    .map(SubjectDTO::parseSubject)
                    .collect(Collectors.toList()))
                .build();
    }
}
