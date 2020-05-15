package com.uxtest.backend.dto.cardsorting;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.model.cardsorting.CardSortingTest;
import com.uxtest.backend.model.cardsorting.Category;
import com.uxtest.backend.model.cardsorting.CategoryWithSubjects;
import com.uxtest.backend.model.test.Task;
import com.uxtest.backend.model.test.Test;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Long id;

    @JsonProperty
    private String name;

    @JsonProperty
    private List<CategoryWithSubjectsDTO> categoriesWithSubjects;

    public Category parseCategory() {
        return Category.builder()
                .id(this.getId())
                .name(this.getName())
                .categoriesWithSubjects(this.getCategoriesWithSubjects()
                    .stream()
                    .map(CategoryWithSubjectsDTO::parseCategoryWithSubjects)
                    .collect(Collectors.toList()))
                .build();
    }
}
